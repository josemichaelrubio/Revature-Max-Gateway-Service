package dev.revaturemax.service;

import dev.revaturemax.model.UserAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
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
        uriComponentsBuilder.queryParam("name", name);
        uriComponentsBuilder.queryParam("email", email);
        String uri = uriComponentsBuilder.toUriString();
        return restTemplate.exchange(uri, HttpMethod.POST,null,Object.class);
    }

    public ResponseEntity<Object> updateEmployee(long employeeId, Object employee) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(EMPLOYEE_SERVICE_URL + "/" + employeeId);
        RequestEntity<Object> requestEntity = new RequestEntity<Object>(employee, HttpMethod.PUT, uriComponentsBuilder.build().toUri());
        String uri = uriComponentsBuilder.toUriString();
        return restTemplate.exchange(uri, HttpMethod.PUT,requestEntity,Object.class);
    }

    public ResponseEntity<Object> setQuizScore(long employeeId, long quizId, Object quizScore) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(EMPLOYEE_SERVICE_URL + "/" + employeeId + "/" + quizId);
        RequestEntity<Object> requestEntity = new RequestEntity<Object>(quizScore, HttpMethod.PUT, uriComponentsBuilder.build().toUri());
        String uri = uriComponentsBuilder.toUriString();
        return restTemplate.exchange(uri, HttpMethod.PUT,requestEntity,Object.class);
    }

    public ResponseEntity<Object> setTopicCompetency(long employeeId, long topicId, Object topicCompetency) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(EMPLOYEE_SERVICE_URL + "/" + employeeId + "/topics/" + topicId);
        RequestEntity<Object> requestEntity = new RequestEntity<Object>(topicCompetency, HttpMethod.PUT, uriComponentsBuilder.build().toUri());
        String uri = uriComponentsBuilder.toUriString();
        return restTemplate.exchange(uri, HttpMethod.PUT,requestEntity,Object.class);
    }

    public ResponseEntity<Object> setQCRating(long employeeId, long qcId, Integer associateRating) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(EMPLOYEE_SERVICE_URL + "/" + employeeId + "/qcs/" + qcId + "/associate-rating");
        uriComponentsBuilder.queryParam("associate-rating", associateRating);
        String uri = uriComponentsBuilder.toUriString();
        return restTemplate.exchange(uri, HttpMethod.PUT,null,Object.class);
    }

    public ResponseEntity<Object> setQCFeedback(long employeeId, long qcId, Integer instructorFeedback) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(EMPLOYEE_SERVICE_URL + "/" + employeeId + "/qcs/" + qcId + "/instructor-feedback");
        uriComponentsBuilder.queryParam("instructor-feedback",instructorFeedback);
        String uri = uriComponentsBuilder.toUriString();
        return restTemplate.exchange(uri, HttpMethod.PUT,null,Object.class);
    }

    public ResponseEntity<Object> getNotesByTopic(Long topicId, Long employeeId) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(EMPLOYEE_SERVICE_URL + "/notes/" + topicId);
        uriComponentsBuilder.queryParam("employee", employeeId);
        String uri = uriComponentsBuilder.toUriString();
        return restTemplate.exchange(uri, HttpMethod.GET,null,Object.class);
    }

    public ResponseEntity<Object> setNotes(long employeeId, Object notes) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(EMPLOYEE_SERVICE_URL + "/" + employeeId + "/notes/");
        RequestEntity<Object> requestEntity = new RequestEntity<Object>(notes, HttpMethod.PUT, uriComponentsBuilder.build().toUri());
        String uri = uriComponentsBuilder.toUriString();
        return restTemplate.exchange(uri, HttpMethod.PUT,requestEntity,Object.class);
    }

    public ResponseEntity<Object> getEmployeeByEmail(String email) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(EMPLOYEE_SERVICE_URL + "/login/" + email);
        String uri = uriComponentsBuilder.toUriString();
        return restTemplate.exchange(uri, HttpMethod.GET,null,Object.class);
    }
}
