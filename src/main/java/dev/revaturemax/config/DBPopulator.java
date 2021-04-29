package dev.revaturemax.config;


import dev.revaturemax.model.UserAuth;
import dev.revaturemax.repository.UserAuthRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DBPopulator implements CommandLineRunner {

    @Autowired
    UserAuthRepository userAuthRepository;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(14);

    @Override
    public void run(String... args) throws Exception {
        userAuthRepository.deleteAll();
        String roles = "GUEST";

        UserAuth guest = new UserAuth("guest", passwordEncoder.encode("pw"));
        guest.setRoles(roles);
        guest.setActive(true);

        roles += ", USER";
        UserAuth user = new UserAuth("user", passwordEncoder.encode("pw"));
        user.setRoles(roles);
        user.setActive(true);

        roles += ", ADMIN";
        UserAuth admin = new UserAuth("admin", passwordEncoder.encode("pw"));
        admin.setRoles(roles);
        admin.setActive(true);

        userAuthRepository.saveAll(Arrays.asList(guest,user,admin));
    }
}
