package dev.revaturemax.controller;

import dev.revaturemax.model.UserAuth;
import dev.revaturemax.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserAuth> handleRegister(@RequestParam("name") String name,
                                               @RequestParam("email") String email,
                                               @RequestParam("password") String password){
        return authService.registerUser(email, password, name);
    }



}
