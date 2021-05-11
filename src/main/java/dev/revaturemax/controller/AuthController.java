package dev.revaturemax.controller;

import dev.revaturemax.model.UserAuth;
import dev.revaturemax.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
public class AuthController {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    AuthService authService;

    @GetMapping("/login")
    public ResponseEntity<String> handleLogin(@RequestBody UserAuth userAuth){
        return authService.login(userAuth);
    }
}
