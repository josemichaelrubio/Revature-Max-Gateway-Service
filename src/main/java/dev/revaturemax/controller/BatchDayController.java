package dev.revaturemax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/batch-days")
@CrossOrigin
public class BatchDayController {

//        private static final String CURRICULUM_SERVICE_URL = "http://40.122.154.60:8085/batch-days";
    private static final String CURRICULUM_SERVICE_URL = "http://localhost:8081/batch-days";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(produces = "application/json")
    public ResponseEntity<Object> getBatchDays(@RequestParam("batch") long batchId){
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(CURRICULUM_SERVICE_URL).queryParam("batch",batchId);
        return restTemplate.exchange(uriComponentsBuilder.toUriString(), HttpMethod.GET,null,Object.class);
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity<Object> setBatchDay(@RequestBody Object requestBody){
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(CURRICULUM_SERVICE_URL);
        RequestEntity<Object> request = new RequestEntity<Object>(requestBody, HttpMethod.PUT,uriComponentsBuilder.build().toUri());
        return restTemplate.exchange(uriComponentsBuilder.toUriString(),HttpMethod.PUT,request,Object.class);
    }

    // quiz post method for batch day refactored from original batch controller
    @PostMapping(value = "/{day-id}/quizzes/{quiz-id}", consumes = "application/json")
    public ResponseEntity<Object> postQuiz(@PathVariable("day-id") long batchDayId,
                                           @PathVariable("quiz-id") long quizId)
    {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(CURRICULUM_SERVICE_URL+"/"+batchDayId+"/quizzes/"+quizId);
        return restTemplate.exchange(uriComponentsBuilder.toUriString(), HttpMethod.GET,null,Object.class);
    }
}
