package dev.revaturemax.service;

import dev.revaturemax.model.UserAuth;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

@PrepareForTest({ Instant.class })
@SpringBootTest
public class JwtServiceTest {

    private String testJWT;
    private final UserAuth userAuth = new UserAuth("username","password","testUser",true,101);
    private final String instantExpected = "2021-01-01T00:00:00Z";
    private final Clock clock = Clock.fixed(Instant.parse(instantExpected), ZoneId.of("UTC"));

    UserAuth newUser;

    @InjectMocks
    JwtService jwtService;
    
    @Before
    public void TestSetup(){
        newUser = new UserAuth("username", "password");
    }

//    @Test
//    public void testGenerateToken(){
//        System.out.println(System.getenv("db_url"));
//        Instant instant = Instant.now(clock);
//        PowerMockito.mockStatic(Instant.class);
//        PowerMockito.when(Instant.now()).thenReturn(instant);
//        Instant now = Instant.now();
//        Assertions.assertEquals(instantExpected,now.toString());
//    }
//    @Test

    @Test
    public void testValidateJWT_whenInvalidReturnFalse(){
        String token = jwtService.generateToken(newUser);
    }

}
