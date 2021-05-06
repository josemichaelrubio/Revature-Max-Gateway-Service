package dev.revaturemax.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Objects;

@Component
@Entity
@Table(name="user-auth")
public class UserAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String roles;
    private boolean active;

    public UserAuth() {
    }

    public UserAuth(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserAuth(String username, String password, String roles, boolean active, int employee) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAuth userAuth = (UserAuth) o;
        return id == userAuth.id && active == userAuth.active && Objects.equals(username, userAuth.username) && Objects.equals(password, userAuth.password) && Objects.equals(roles, userAuth.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, roles, active);
    }

    @Override
    public String toString() {
        return "UserAuth{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", roles='" + roles + '\'' +
                ", active=" + active +
                '}';
    }
}
