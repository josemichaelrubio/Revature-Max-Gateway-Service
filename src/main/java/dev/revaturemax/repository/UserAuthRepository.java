package dev.revaturemax.repository;

import dev.revaturemax.model.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthRepository extends JpaRepository<UserAuth, Integer> {

    public UserAuth findByUsername(String username);
}
