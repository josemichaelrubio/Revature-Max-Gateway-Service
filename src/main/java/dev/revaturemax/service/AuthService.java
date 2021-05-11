package dev.revaturemax.service;

import dev.revaturemax.model.UserAuth;
import dev.revaturemax.repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    UserAuthRepository userAuthRepository;

    public ResponseEntity<String> login(UserAuth userAuth) {
        UserAuth userCredentails = userAuthRepository.findByUsername(userAuth.getUsername());


        return null;
    }
}
