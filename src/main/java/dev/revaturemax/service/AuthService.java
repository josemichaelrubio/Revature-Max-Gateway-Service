package dev.revaturemax.service;

import dev.revaturemax.exception.UnauthorizedException;
import dev.revaturemax.model.UserAuth;
import dev.revaturemax.repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService {

    @Autowired
    UserAuthRepository userAuthRepository;
    @Autowired
    HashService hashService;
    @Autowired
    JwtService jwtService;

    public ResponseEntity<String> login(UserAuth userAuth) {
        UserAuth userCredentails = userAuthRepository.findByUsername(userAuth.getUsername());
        if(!hashService.validatePassword(userAuth.getPassword(), userCredentails))
            throw new UnauthorizedException("Invalid e-mail or password entered.");
        String token = jwtService.generateToken(userAuth);
        Long employeeID = Long.parseLong(jwtService.extractSubject(token));
        HttpHeaders headers = new HttpHeaders();
        List<String> exposeHeaders = new ArrayList<>();
        exposeHeaders.add("Authorization");
        exposeHeaders.add("EmployeeID");
        headers.setAccessControlExposeHeaders(exposeHeaders);
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body("");
    }
}
