package dev.revaturemax.controller;

import com.sun.jndi.toolkit.url.Uri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Set;

public class CurriculumController {

    private static final String CURRICULUM_SERVICE_URL = "http://localhost/curriculum";

    @Autowired
    RestTemplate restTemplate;


    @GetMapping("/{curriculum-id}/techs")
    public ResponseEntity<Object> getCurriculumTechs(@PathVariable long id) {
        String requestUrl = CURRICULUM_SERVICE_URL + "/" + id + "/techs";
        return restTemplate.exchange(requestUrl, HttpMethod.GET, new HttpEntity<Object>(new HttpHeaders()), Object.class);
    }

    @GetMapping("/techs")
    public ResponseEntity<Object> getTechs() {
        String requestUrl = CURRICULUM_SERVICE_URL + "/techs";
        return restTemplate.exchange(requestUrl, HttpMethod.GET, new HttpEntity<Object>(new HttpHeaders()), Object.class);
    }

//    @PostMapping("/techs")
//    public ResponseEntity<Tech> postNewTopicTag(@RequestBody Tech tech) {
//        Tech newTech = curriculumService.createTech(tech);
//        return new ResponseEntity<>(newTech, HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("/techs/{id}")
//    public ResponseEntity<HttpStatus> deleteTopicTag(@PathVariable long id) {
//        curriculumService.deleteTech(id);
//        return new ResponseEntity<>(HttpStatus.ACCEPTED);
//    }
//
//    @GetMapping("/topics")
//    public ResponseEntity<Object> getMultipleTopics(@RequestParam Set<Long> topicIds) {
//        String requestUrl = CURRICULUM_SERVICE_URL + "/topics";
//        return ResponseEntity.ok().body(curriculumService.getMultipleTopics(topicIds));
//    }
//
//    @GetMapping("/techs/{techId}/topics")
//    public ResponseEntity<List<Topic>> getAllTopics(@PathVariable long techId) {
//        return ResponseEntity.ok().body(curriculumService.getTopics(techId));
//    }
//
//    @PutMapping("/techs/{tech-id}/topics")
//    public ResponseEntity<HttpStatus> updateTopic(@PathVariable long id,
//                                                  @RequestBody List<Topic> topics) {
//        curriculumService.updateTopics(id, topics);
//        return new ResponseEntity<>(HttpStatus.ACCEPTED);
//    }
//
//    @DeleteMapping("/techs/{tech-id}/topics/{topic-id}")
//    public ResponseEntity<HttpStatus> deleteTopic(@PathVariable(name = "tech-id") long techId,
//                                                  @PathVariable(name = "topic-id") long topicId) {
//        curriculumService.removeTopic(techId, topicId);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @GetMapping(value = "/quizzes", produces = "application/json")
//    public ResponseEntity<List<Quiz>> getMultipleQuizzes(@RequestParam(required = false) Set<Long> ids){
//        if (ids != null)
//            return ResponseEntity.ok().body(curriculumService.getMultipleQuizzes(ids));
//        else
//            return ResponseEntity.ok().body(curriculumService.getAllQuizzes());
//    }
//
//    @GetMapping("/quizzes/{quiz-id}")
//    public ResponseEntity<Quiz> getQuiz(@PathVariable("quiz-id") long quizId){
//        return ResponseEntity.ok().body(curriculumService.getOneQuiz(quizId));
//    }
//
//    @PutMapping(value = "/quizzes/{quiz-id}/techs", consumes = "application/json")
//    public ResponseEntity<HttpStatus> putQuiz(@PathVariable("quiz-id") long quizId,
//                                              @RequestBody List<Tech> techs) {
//        return curriculumService.updateQuizzes(quizId, techs);
//    }
//
//    @DeleteMapping(value = "/quizzes/{quiz-id}/techs/{tech-id}")
//    public ResponseEntity<HttpStatus> removeQuiz(@PathVariable("tech-id") long techId,
//                                                 @PathVariable("quiz-id") long quizId) {
//        return curriculumService.removeQuiz(techId, quizId);
//    }
//
//    @GetMapping(value="/qcs", produces="application/json")
//    public ResponseEntity<List<QC>> getMultipleQCs(@RequestParam(required = false) Set<Long> qcIds) {
//        if (qcIds != null)
//            return ResponseEntity.ok(curriculumService.getMultipleQCs(qcIds));
//        else
//            return ResponseEntity.ok().body(curriculumService.getAllQC());
//    }


}