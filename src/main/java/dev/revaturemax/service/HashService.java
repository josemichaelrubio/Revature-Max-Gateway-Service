package dev.revaturemax.service;

import dev.revaturemax.model.UserAuth;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public class HashService {

    private final PasswordEncoder encoder = new BCryptPasswordEncoder(14);

    public String hashPassword(String password){
        return encoder.encode(password);
    }

    public boolean validatePassword(String password, UserAuth userAuth){
        return encoder.matches(password, userAuth.getPassword());
    }
}
