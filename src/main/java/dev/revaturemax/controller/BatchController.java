package dev.revaturemax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/batches")
@CrossOrigin
public class BatchController {

    @Autowired
    RestTemplate restTemplate;
    private static final String BATCH_SERVICE_URL = "http://40.76.1.66:8083/batches";

    @GetMapping(value = "/{batch-id}", produces = "application/json")
    public ResponseEntity<Object> handleGetBatchInfoById(@PathVariable("batch-id") long id) {
        UriComponentsBuilder requestUri = UriComponentsBuilder.fromHttpUrl(BATCH_SERVICE_URL + "/" + id);
        return restTemplate.exchange(requestUri.toUriString(),HttpMethod.GET,null,Object.class);
    }


    @GetMapping("/{batch-id}/associates")
    public ResponseEntity<Object> getAssociates(@PathVariable("batch-id") long batchId) {
        UriComponentsBuilder requestUri = UriComponentsBuilder.fromHttpUrl(BATCH_SERVICE_URL + "/" + batchId + "/associates");
        return restTemplate.exchange(requestUri.toUriString(),HttpMethod.GET,null,Object.class);
    }

    @PostMapping("/{batch-id}/associates")
    public ResponseEntity<Object> postAssociates(@PathVariable("batch-id") long batchId,
                                                 @RequestBody Object requestBody)
    {
        UriComponentsBuilder requestUri = UriComponentsBuilder.fromHttpUrl(BATCH_SERVICE_URL + "/" + batchId + "/associates");
        RequestEntity<Object> request = new RequestEntity<Object>(requestBody, HttpMethod.POST,requestUri.build().toUri());
        return restTemplate.exchange(requestUri.toUriString(),HttpMethod.POST,request,Object.class);
    }

    @GetMapping("/{employee-id}/batch")
    public ResponseEntity<Object> getBatchByEmployeeId(@PathVariable("employee-id") long employeeId)
    {
        UriComponentsBuilder requestUri = UriComponentsBuilder.fromHttpUrl(BATCH_SERVICE_URL + "/" + employeeId + "/batch");
        return restTemplate.exchange(requestUri.toUriString(),HttpMethod.GET,null,Object.class);
    }

    @DeleteMapping("/{batch-id}/associates/{employee-id}")
    public ResponseEntity<Object> deleteAssociate(@PathVariable("batch-id") long batchId,
                                                      @PathVariable("employee-id") long employeeId)
    {
        UriComponentsBuilder requestUri = UriComponentsBuilder.fromHttpUrl(BATCH_SERVICE_URL + "/" + batchId + "/associates/" + employeeId);
        return restTemplate.exchange(requestUri.toUriString(),HttpMethod.DELETE,null,Object.class);

    }



}
