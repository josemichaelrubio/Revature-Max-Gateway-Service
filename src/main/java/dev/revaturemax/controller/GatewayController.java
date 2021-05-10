package dev.revaturemax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class GatewayController {

    private static final String BATCH_SERVICE_URL = "http://batch-service/batches";
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/batches/{pathString}")
    public ResponseEntity<Object> batchGetController(@PathVariable("pathString") String pathString){
        String requestURL = BATCH_SERVICE_URL + "/" + pathString;
        return restTemplate.exchange(requestURL, HttpMethod.GET,null,Object.class);
    }

    @PostMapping("/batches/{pathString}")
    public ResponseEntity<Object> batchPostController(@PathVariable("pathString") String pathString){
        String requestURL = BATCH_SERVICE_URL + "/" + pathString;
        return restTemplate.exchange(requestURL, HttpMethod.GET,null,Object.class);
    }

    @DeleteMapping("/batches/{pathString}")
    public ResponseEntity<Object> batchDeleteController(@PathVariable("pathString") String pathString){
        String requestURL = BATCH_SERVICE_URL + "/" + pathString;
        return restTemplate.exchange(requestURL, HttpMethod.GET,null,Object.class);
    }

    @GetMapping("/batches/{pathString}")
    public ResponseEntity<Object> curriculumGetController(@PathVariable("pathString") String pathString){
        String requestURL = BATCH_SERVICE_URL + "/" + pathString;
        return restTemplate.exchange(requestURL, HttpMethod.GET,null,Object.class);
    }

    @PostMapping("/batches/{pathString}")
    public ResponseEntity<Object> curriculumPostController(@PathVariable("pathString") String pathString){
        String requestURL = BATCH_SERVICE_URL + "/" + pathString;
        return restTemplate.exchange(requestURL, HttpMethod.GET,null,Object.class);
    }

    @PutMapping("/batches/{pathString}")
    public ResponseEntity<Object> curriculumPutController(@PathVariable("pathString") String pathString){
        String requestURL = BATCH_SERVICE_URL + "/" + pathString;
        return restTemplate.exchange(requestURL, HttpMethod.GET,null,Object.class);
    }

    @DeleteMapping("/batches/{pathString}")
    public ResponseEntity<Object> curriculumDeleteController(@PathVariable("pathString") String pathString){
        String requestURL = BATCH_SERVICE_URL + "/" + pathString;
        return restTemplate.exchange(requestURL, HttpMethod.GET,null,Object.class);
    }
}
