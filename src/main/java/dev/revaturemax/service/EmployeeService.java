package dev.revaturemax.service;

import dev.revaturemax.model.UserAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Set;

@Component
public class EmployeeService {

    private static final String EMPLOYEE_SERVICE_URL = "http://20.185.67.43:8082/employees";
    @Autowired
    RestTemplate restTemplate;


    public ResponseEntity<Object> getEmployee(long employeeId, Set<String> fields) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(EMPLOYEE_SERVICE_URL + "/" + employeeId);
        uriComponentsBuilder.queryParam("field", fields);
        String uri = uriComponentsBuilder.toUriString();
        return restTemplate.exchange(uri, HttpMethod.GET,null,Object.class);
    }

    public ResponseEntity<Object> getEmployees(Set<Long> employeeIds, Set<String> emails, Set<String> fields) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(EMPLOYEE_SERVICE_URL);
        uriComponentsBuilder.queryParam("id", employeeIds);
        uriComponentsBuilder.queryParam("email", emails);
        uriComponentsBuilder.queryParam("field", fields);
        String uri = uriComponentsBuilder.toUriString();
        return restTemplate.exchange(uri, HttpMethod.GET,null,Object.class);

    }

    public ResponseEntity<Object> createNewEmployee(String name, String email) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(EMPLOYEE_SERVICE_URL);
        uriComponentsBuilder.queryParam("id", name);
        uriComponentsBuilder.queryParam("email", email);
        String uri = uriComponentsBuilder.toUriString();
        return restTemplate.exchange(uri, HttpMethod.POST,null,Object.class);
    }

    public ResponseEntity<Object> updateEmployee(long employeeId, Object employee) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(EMPLOYEE_SERVICE_URL + "/" + employeeId);
        String uri = uriComponentsBuilder.toUriString();
        return restTemplate.exchange(uri, HttpMethod.PUT,null,Object.class);
    }

    public ResponseEntity<Object> setQuizScore(long employeeId, long quizId, Object quizScore) {
    }

    public ResponseEntity<Object> setTopicCompetency(long employeeId, long topicId, Object topicCompetency) {
    }

    public ResponseEntity<Object> setQCRating(long employeeId, long qcId, Integer associateRating) {
    }

    public ResponseEntity<Object> setQCFeedback(long employeeId, long qcId, Integer instructorFeedback) {
    }

    public ResponseEntity<Object> getNotesByTopic(Long topicId, Long employeeId) {
    }

    public ResponseEntity<Object> setNotes(long employeeId, Object notes) {
    }

    public ResponseEntity<Object> getEmployeeByEmail(String email) {
    }
}
