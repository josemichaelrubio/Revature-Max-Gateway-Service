package dev.revaturemax.service;

import dev.revaturemax.model.LoginUserDetails;
import dev.revaturemax.model.UserAuth;
import dev.revaturemax.repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginUserDetailService implements UserDetailsService {

    @Autowired
    private UserAuthRepository userAuthRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuth dbUser = userAuthRepository.findByUsername(username);
        if(dbUser==null)
            throw new RuntimeException("User not found");
        return new LoginUserDetails(dbUser);
    }
}
