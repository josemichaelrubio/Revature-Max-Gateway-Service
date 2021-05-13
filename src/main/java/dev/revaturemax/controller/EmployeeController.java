package dev.revaturemax.controller;

import dev.revaturemax.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(path = "/{employee-id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getEmployee(@PathVariable("employee-id") long employeeId,
                                              @RequestParam(value = "field", required = false) Set<String> fields)
    {
        return employeeService.getEmployee(employeeId, fields);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getEmployees(@RequestParam(value = "id", required = false) Set<Long> employeeIds,
                                               @RequestParam(value = "email", required = false) Set<String> emails,
                                               @RequestParam(value = "field", required = false) Set<String> fields)
    {
        return employeeService.getEmployees(employeeIds, emails, fields);
    }

    @PostMapping
    public ResponseEntity<Object> createNewEmployee(@RequestParam("name") String name,
                                                  @RequestParam("email") String email)
    {
        return employeeService.createNewEmployee(name, email);
    }

    @PutMapping(path = "/{employee-id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateEmployee(@PathVariable("employee-id") long employeeId,
                                                   @RequestBody Object employee)
    {
        return employeeService.updateEmployee(employeeId, employee);
    }

    @PutMapping(path = "/{employee-id}/quizzes/{quiz-id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> setQuizScore(@PathVariable("employee-id") long employeeId,
                                               @PathVariable("quiz-id") long quizId,
                                               @RequestBody Object quizScore)
    {
        return employeeService.setQuizScore(employeeId, quizId, quizScore);
    }

    @PutMapping(path = "/{employee-id}/topics/{topic-id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> setTopicCompetency(@PathVariable("employee-id") long employeeId,
                                                     @PathVariable("topic-id") long topicId,
                                                     @RequestBody Object topicCompetency)
    {
        return employeeService.setTopicCompetency(employeeId, topicId, topicCompetency);
    }

    @PutMapping(path = "/{employee-id}/qcs/{qc-id}/associate-rating",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<Object> setQCRating(@PathVariable("employee-id") long employeeId,
                                              @PathVariable("qc-id") long qcId,
                                              @RequestParam("associate-rating") Integer associateRating)
    {
        return employeeService.setQCRating(employeeId, qcId, associateRating);
    }

    @PutMapping(path = "/{employee-id}/qcs/{qc-id}/instructor-feedback",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<Object> setQCFeedback(@PathVariable("employee-id") long employeeId,
                                                @PathVariable("qc-id") long qcId,
                                                @RequestParam("instructor-feedback") Integer instructorFeedback)
    {
        return employeeService.setQCFeedback(employeeId, qcId, instructorFeedback);
    }

    @GetMapping("/notes/{topic-id}")
    public ResponseEntity<Object> getNotesByTopic(@PathVariable("topic-id") Long topicId,
                                                    @RequestParam("employee") Long employeeId) {
        return employeeService.getNotesByTopic(topicId, employeeId);
    }

    @PutMapping(path = "/{employee-id}/notes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> setNotes(@PathVariable("employee-id") long employeeId,
                                           @RequestBody Object notes)
    {
        return employeeService.setNotes(employeeId, notes);
    }

//    @GetMapping(path = "/{employee-id}/notes", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<String> getFavoriteNotes(@PathVariable("employee-id") long employeeId,
//                                                   @RequestBody FavNotesDTO favNotesDTO)
//    {
//
//        logger.info("Getting favorite notes with id: ", favNotesId);
//        return notesService.getFavNotes(favNotesId, favNotesDTO);
//    }


    @GetMapping("/login/{email}")
    public ResponseEntity<Object> getIdByEmail(@PathVariable("email") String email){
        return employeeService.getEmployeeByEmail(email);
    }
}
