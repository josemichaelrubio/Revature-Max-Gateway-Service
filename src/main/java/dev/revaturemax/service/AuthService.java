package dev.revaturemax.service;

import dev.revaturemax.exception.UnauthorizedException;
import dev.revaturemax.model.UserAuth;
import dev.revaturemax.repository.UserAuthRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.xml.ws.Response;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService {

    @Autowired
    UserAuthRepository userAuthRepository;
    @Autowired
    HashService hashService;
    @Autowired
    JwtService jwtService;

    @Autowired
    RestTemplate restTemplate;

    private static final String EMPLOYEE_SERVICE_URL = "http://20.185.67.43:8082/employees";
    private static final String EMPLOYEE_SERVICE_URL_LOCAL = "http://localhost:8082/employees";

    public ResponseEntity<String> login(UserAuth userAuth) {
        UserAuth userCredentails = userAuthRepository.findByUsername(userAuth.getUsername());
        if(!hashService.validatePassword(userAuth.getPassword(), userCredentails))
            throw new UnauthorizedException("Invalid e-mail or password entered.");
        String token = jwtService.generateToken(userAuth);
        Long employeeID = Long.parseLong(jwtService.extractSubject(token));
        HttpHeaders headers = new HttpHeaders();
        List<String> exposeHeaders = new ArrayList<>();
        exposeHeaders.add("Authorization");
        exposeHeaders.add("EmployeeID");
        headers.setAccessControlExposeHeaders(exposeHeaders);
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body("");
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
