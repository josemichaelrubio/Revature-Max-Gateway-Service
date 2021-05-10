package dev.revaturemax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
//@RequestMapping("/batches")
public class BatchController {

    private static final String BATCH_SERVICE_URL = "http://batch-service/batches";
    @Autowired
    RestTemplate restTemplate;
//
//    @GetMapping(value="/{id}")
//    public ResponseEntity<Object> getBatchById(@PathVariable("id") long id){
//        String requestURL = BATCH_SERVICE_URL + "/" + id;
//        return restTemplate.exchange(requestURL,HttpMethod.GET,null,Object.class);
//    }



}
