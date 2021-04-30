//package dev.revaturemax.service;
//
//import dev.revaturemax.model.UserAuth;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.powermock.api.mockito.PowerMockito;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.Clock;
//import java.time.Instant;
//import java.time.ZoneId;
//
//@RunWith(PowerMockRunner.class)
//@PrepareForTest({ Instant.class })
//@SpringBootTest
//public class JwtServiceTest {
//
//    private String testJWT;
//    private final UserAuth userAuth = new UserAuth("username","password","testUser",true,101);
//    private final String instantExpected = "2021-01-01T00:00:00Z";
//    private final Clock clock = Clock.fixed(Instant.parse(instantExpected), ZoneId.of("UTC"));
//
//    @Mock
//    Instant instant;
//
//    @Test
//    public void testGenerateToken(){
//        System.out.println(System.getenv("db_url"));
//        Instant instant = Instant.now(clock);
//        PowerMockito.mockStatic(Instant.class);
//        PowerMockito.when(Instant.now()).thenReturn(instant);
//        Instant now = Instant.now();
//        Assertions.assertEquals(instantExpected,now.toString());
//    }
//}
