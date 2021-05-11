package dev.revaturemax.service;

import dev.revaturemax.model.UserAuth;
import dev.revaturemax.repository.UserAuthRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.xml.ws.Response;

@Service
public class AuthService {

    @Autowired
    UserAuthRepository userAuthRepository;

    @Autowired
    RestTemplate restTemplate;

    private static final String EMPLOYEE_SERVICE_URL = "http://20.185.67.43:8082/employees";
    private static final String EMPLOYEE_SERVICE_URL_LOCAL = "http://localhost:8082/employees";

    public ResponseEntity<String> login(UserAuth userAuth) {
        UserAuth userCredentails = userAuthRepository.findByUsername(userAuth.getUsername());


        return null;
    }
    public ResponseEntity<UserAuth> registerUser(String name, String email, String password) {
        //begins building uri for employee call
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(EMPLOYEE_SERVICE_URL);
        uriComponentsBuilder.queryParam("name", name);
        uriComponentsBuilder.queryParam("email", email);
        uriComponentsBuilder.queryParam("password", password);
        String uri = uriComponentsBuilder.toUriString();
        ResponseEntity<Long> employeeResponse = restTemplate.exchange(uri, HttpMethod.POST, new HttpEntity<Long>(new HttpHeaders()), Long.class);
        Long employeeId = employeeResponse.getBody();

        UserAuth userAuth = new UserAuth(email, password, "GUEST", false, employeeId);
        userAuth = userAuthRepository.save(userAuth);
        return new ResponseEntity<>(userAuth, HttpStatus.OK);

    }
}
