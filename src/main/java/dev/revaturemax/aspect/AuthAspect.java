package dev.revaturemax.aspect;

import dev.revaturemax.model.UserAuth;
import dev.revaturemax.repository.UserAuthRepository;
import dev.revaturemax.service.JwtService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class AuthAspect {

    private Logger logger = LogManager.getLogger(AuthAspect.class);
    @Autowired
    UserAuthRepository userAuthRepository;
    @Autowired
    JwtService jwtService;

    @Around("within(dev.revaturemax.controller.*)&&!this(dev.revaturemax.controller.AuthController)")
    public ResponseEntity authorizeRequest(ProceedingJoinPoint jp) throws Throwable {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization");
        if(token!=null){
            logger.info("auth token present");
            UserAuth user = userAuthRepository.findByEmployee(Long.parseLong(jwtService.extractSubject(token)));
            if(jwtService.validateToken(token, user)){
                logger.info("Token validated");
                return (ResponseEntity) jp.proceed();
            }
            logger.warn("Token not valid");
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        } else {
            logger.warn("auth header not present");
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }
}
