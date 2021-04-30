package dev.revaturemax.service;

import dev.revaturemax.model.UserAuth;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;

import static reactor.core.publisher.Mono.when;

@SpringBootTest
public class JwtServiceTest {

    private String testJWT;
    private UserAuth userAuth = new UserAuth("username","password","testUser",true,101);

    @BeforeAll
    public void setup(){

    }

    public void testGenerateToken(){
        when(System.currentTimeMillis()).thenReturn(1000);
    }
}
