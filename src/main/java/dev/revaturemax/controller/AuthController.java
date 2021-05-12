package dev.revaturemax.controller;

import dev.revaturemax.model.UserAuth;
import dev.revaturemax.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping
@CrossOrigin
public class AuthController {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    AuthService authService;

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> handleLogin(@RequestParam("email") String email,
                                              @RequestParam("password") String password){
        return authService.login(new UserAuth(email, password));
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<UserAuth> handleRegister(@RequestParam("name") String name,
                                               @RequestParam("email") String email,
                                               @RequestParam("password") String password){
        return authService.registerUser(email, password, name);
    }

    @GetMapping(value = "/verify/{employeeId}")
    public RedirectView verifyUserAuth(@PathVariable Long employeeId){
        authService.verifyUser(employeeId);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://revaturemax.z19.web.core.windows.net/login");
        return redirectView;
    }



}
