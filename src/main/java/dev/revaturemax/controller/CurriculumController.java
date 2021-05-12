package dev.revaturemax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Set;

@RestController
@RequestMapping("/curriculum")
@CrossOrigin
public class CurriculumController {

    private static final String CURRICULUM_SERVICE_URL = "http://40.122.154.60:8085/curriculum";
    @Autowired
    RestTemplate restTemplate;


    @GetMapping("/{curriculumId}/techs")
    public ResponseEntity<Object> getCurriculumTechs(@PathVariable long curriculumId) {
        String requestUrl = CURRICULUM_SERVICE_URL + "/" + curriculumId + "/techs";
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(requestUrl);
        return restTemplate.exchange(uriComponentsBuilder.toUriString(), HttpMethod.GET, new HttpEntity<Object>(new HttpHeaders()), Object.class);
    }


    @GetMapping("/techs")
    public ResponseEntity<Object> getTechs() {
        String requestUrl = CURRICULUM_SERVICE_URL + "/techs";
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(requestUrl);
        return restTemplate.exchange(uriComponentsBuilder.toUriString(), HttpMethod.GET, new HttpEntity<Object>(new HttpHeaders()), Object.class);
    }


    @PostMapping("/techs")
    public ResponseEntity<Object> postNewTopicTag(@RequestBody Object requestBody) {
        String requestUrl = CURRICULUM_SERVICE_URL + "/techs";
        UriComponentsBuilder uri = UriComponentsBuilder.fromHttpUrl(requestUrl);
        RequestEntity<Object> request = new RequestEntity<Object>(requestBody, HttpMethod.POST, uri.build().toUri());
        return restTemplate.exchange(requestUrl, HttpMethod.POST, request, Object.class);
    }


    @DeleteMapping("/techs/{id}")
    public ResponseEntity<HttpStatus> deleteTopicTag(@PathVariable long id) {
        String requestUrl = CURRICULUM_SERVICE_URL + "/techs/" + id;
        return restTemplate.exchange(requestUrl, HttpMethod.DELETE, new HttpEntity<HttpStatus>(new HttpHeaders()), HttpStatus.class);
    }


    @GetMapping("/topics")
    public ResponseEntity<Object> getMultipleTopics(@RequestParam Object topicIds) {
        String requestUrl = CURRICULUM_SERVICE_URL + "/topics";
        UriComponentsBuilder uri = UriComponentsBuilder.fromHttpUrl(requestUrl);
        uri.queryParam("topicIds", topicIds);

        return restTemplate.exchange(uri.toUriString(), HttpMethod.GET, null, Object.class);
    }

    @GetMapping("/techs/{techId}/topics")
    public ResponseEntity<Object> getAllTopics(@PathVariable long techId) {
        String requestUrl = CURRICULUM_SERVICE_URL + "/techs/" + techId + "/topics";
        return restTemplate.exchange(requestUrl, HttpMethod.GET, new HttpEntity<Object>(new HttpHeaders()), Object.class);
    }

    @PutMapping("/techs/{tech-id}/topics")
    public ResponseEntity<HttpStatus> updateTopic(@PathVariable long id,
                                                  @RequestBody Object topics) {
        String requestUrl = CURRICULUM_SERVICE_URL + "/techs/" + id + "/topics";
        UriComponentsBuilder uri = UriComponentsBuilder.fromHttpUrl(requestUrl);
        RequestEntity<Object> request = new RequestEntity<Object>(topics, HttpMethod.PUT, uri.build().toUri());
        return restTemplate.exchange(uri.toUriString(), HttpMethod.PUT, request, HttpStatus.class);
    }

    @DeleteMapping("/techs/{tech-id}/topics/{topic-id}")
    public ResponseEntity<HttpStatus> deleteTopic(@PathVariable(name = "tech-id") long techId,
                                                  @PathVariable(name = "topic-id") long topicId) {
        String requestUrl = CURRICULUM_SERVICE_URL + "/techs/" + techId + "/topics/" + topicId;
        return restTemplate.exchange(requestUrl, HttpMethod.DELETE, new HttpEntity<HttpStatus>(new HttpHeaders()), HttpStatus.class);

    }

    @GetMapping(value = "/quizzes", produces = "application/json")
    public ResponseEntity<Object> getMultipleQuizzes(@RequestParam(required = false) Set<Long> ids){
        String requestUrl = CURRICULUM_SERVICE_URL + "/quizzes";
        return restTemplate.exchange(requestUrl, HttpMethod.GET, new HttpEntity<Object>(new HttpHeaders()), Object.class);
    }


    @GetMapping("/quizzes/{quiz-id}")
    public ResponseEntity<Object> getQuiz(@PathVariable("quiz-id") long quizId){
        String requestUrl = CURRICULUM_SERVICE_URL + "/quizzes/" + quizId;
        return restTemplate.exchange(requestUrl, HttpMethod.GET, new HttpEntity<Object>(new HttpHeaders()), Object.class);
    }

    @PutMapping(value = "/quizzes/{quiz-id}/techs", consumes = "application/json")
    public ResponseEntity<HttpStatus> putQuiz(@PathVariable("quiz-id") long quizId,
                                              @RequestBody Object techs) {

        String requestUrl = CURRICULUM_SERVICE_URL + "/quizzes/" + quizId + "/techs";
        UriComponentsBuilder uri = UriComponentsBuilder.fromHttpUrl(requestUrl);
        RequestEntity<Object> request = new RequestEntity<Object>(techs, HttpMethod.PUT, uri.build().toUri());
        return restTemplate.exchange(uri.toUriString(), HttpMethod.PUT, request, HttpStatus.class);
    }

    @DeleteMapping(value = "/quizzes/{quiz-id}/techs/{tech-id}")
    public ResponseEntity<HttpStatus> removeQuiz(@PathVariable("tech-id") long techId,
                                                 @PathVariable("quiz-id") long quizId) {
        String requestUrl = CURRICULUM_SERVICE_URL + "/quizzes/" + quizId + "/techs/" + techId;
        return restTemplate.exchange(requestUrl, HttpMethod.DELETE, new HttpEntity<HttpStatus>(new HttpHeaders()), HttpStatus.class);
    }

    @GetMapping(value="/qcs", produces="application/json")
    public ResponseEntity<Object> getMultipleQCs(@RequestParam(required = false) Object qcIds) {
        String requestUrl = CURRICULUM_SERVICE_URL + "/qcs";
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(requestUrl);
        return restTemplate.exchange(uriComponentsBuilder.toUriString(), HttpMethod.GET, new HttpEntity<Object>(new HttpHeaders()), Object.class);
    }
}