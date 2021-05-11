package dev.revaturemax.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EmployeeService {

    private static final String EMPLOYEE_SERVICE_URL = "http://20.185.67.43:8082/employees";
    @Autowired
    RestTemplate restTemplate;

    public Long getEmployeeID(String username){
        String requestURL = EMPLOYEE_SERVICE_URL + "/login/" + username;
        return restTemplate.exchange(requestURL, HttpMethod.GET, null, Long.class).getBody();
    }
}
