package dev.revaturemax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
public class AuthController {

    @Autowired
    RestTemplate restTemplate;

//    @GetMapping("/actuator/health")
//    public ResponseEntity<Object> checkHealth(){
//        return restTemplate.exchange("http://");
//    }
}
