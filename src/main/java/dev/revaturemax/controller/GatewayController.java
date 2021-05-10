package dev.revaturemax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
public class GatewayController {

    private static final String BATCH_SERVICE_URL = "http://40.76.1.66/batches";
    private static final String CURRICULUM_SERVICE_URL = "http://40.122.154.60/curriculum";
    private static final String BATCH_DAYS_SERVICE_URL = "http://40.122.154.60/batch-days";
    private static final String EMPLOYEES_SERVICE_URL = "http://20.185.67.43/employees";
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
        return restTemplate.exchange(requestURL, HttpMethod.POST,null,Object.class);
    }

    @DeleteMapping("/batches/{pathString}")
    public ResponseEntity<Object> batchDeleteController(@PathVariable("pathString") String pathString){
        String requestURL = BATCH_SERVICE_URL + "/" + pathString;
        return restTemplate.exchange(requestURL, HttpMethod.DELETE,null,Object.class);
    }

    @GetMapping("/curriculum/{pathString}")
    public ResponseEntity<Object> curriculumGetController(@PathVariable("pathString") String pathString){
        String requestURL = CURRICULUM_SERVICE_URL + "/" + pathString;
        return restTemplate.exchange(requestURL, HttpMethod.GET,null,Object.class);
    }

    @PostMapping("/curriculum/{pathString}")
    public ResponseEntity<Object> curriculumPostController(@PathVariable("pathString") String pathString){
        String requestURL = CURRICULUM_SERVICE_URL + "/" + pathString;
        return restTemplate.exchange(requestURL, HttpMethod.POST,null,Object.class);
    }

    @PutMapping("/curriculum/{pathString}")
    public ResponseEntity<Object> curriculumPutController(@PathVariable("pathString") String pathString){
        String requestURL = CURRICULUM_SERVICE_URL + "/" + pathString;
        return restTemplate.exchange(requestURL, HttpMethod.PUT,null,Object.class);
    }

    @DeleteMapping("/curriculum/{pathString}")
    public ResponseEntity<Object> curriculumDeleteController(@PathVariable("pathString") String pathString){
        String requestURL = CURRICULUM_SERVICE_URL + "/" + pathString;
        return restTemplate.exchange(requestURL, HttpMethod.DELETE,null,Object.class);
    }

    @GetMapping("/batch-days")
    public ResponseEntity<Object> batchDaysGetController(){
        return restTemplate.exchange(BATCH_DAYS_SERVICE_URL, HttpMethod.GET,null,Object.class);
    }

    @PostMapping("/batch-days/{pathString}")
    public ResponseEntity<Object> batchDaysPostController(@PathVariable("pathString") String pathString){
        String requestURL = BATCH_DAYS_SERVICE_URL + "/" + pathString;
        return restTemplate.exchange(requestURL, HttpMethod.POST,null,Object.class);
    }

    @PutMapping("/batch-days")
    public ResponseEntity<Object> batchDaysPutController(@PathVariable("pathString") String pathString){
        return restTemplate.exchange(BATCH_DAYS_SERVICE_URL, HttpMethod.PUT,null,Object.class);
    }

    @GetMapping("/employees")
    public ResponseEntity<Object> employeesSimpleGetController(){
        return restTemplate.exchange(EMPLOYEES_SERVICE_URL, HttpMethod.GET,null,Object.class);
    }

    @PostMapping("/employees")
    public ResponseEntity<Object> employeesSimplePostController(){
        return restTemplate.exchange(EMPLOYEES_SERVICE_URL, HttpMethod.POST,null,Object.class);
    }

    @GetMapping("/employees/{pathString}")
    public ResponseEntity<Object> employeesGetController(@PathVariable("pathString") String pathString){
        String requestURL = EMPLOYEES_SERVICE_URL + "/" + pathString;
        return restTemplate.exchange(requestURL, HttpMethod.GET,null,Object.class);
    }

    @PutMapping("/employees/{pathString}")
    public ResponseEntity<Object> employeesPutController(@PathVariable("pathString") String pathString){
        String requestURL = EMPLOYEES_SERVICE_URL + "/" + pathString;
        return restTemplate.exchange(requestURL, HttpMethod.PUT,null,Object.class);
    }
}