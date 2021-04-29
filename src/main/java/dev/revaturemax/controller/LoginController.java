package dev.revaturemax.controller;

import dev.revaturemax.dto.UserAuthDTO;
import dev.revaturemax.service.JwtService;
import dev.revaturemax.service.LoginUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    LoginUserDetailService loginUserDetailService;
    @Autowired
    JwtService jwtService;

    @PostMapping
    public ResponseEntity<?> authenticate(@RequestBody UserAuthDTO userAuth){
        try {
            final Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userAuth.getUsername(),
                            userAuth.getPassword()
                    )
            );
        } catch(AuthenticationException e){
            throw new RuntimeException(e.getMessage());
        }
        UserDetails userDetails = loginUserDetailService.loadUserByUsername(userAuth.getUsername());
        String token = jwtService.generateToken(userDetails);
        return ResponseEntity.ok().body(token);
    }
}
