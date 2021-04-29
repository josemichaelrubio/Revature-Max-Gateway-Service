package dev.revaturemax.dto;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserAuthDTO {

    private String username;
    private String password;
    private String roles;
    private boolean active;
    private int employee;

    public UserAuthDTO() {
    }

    public UserAuthDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserAuthDTO(String username, String password, String roles, boolean active, int employee) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.active = active;
        this.employee = employee;
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

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAuthDTO that = (UserAuthDTO) o;
        return active == that.active && employee == that.employee && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(roles, that.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, roles, active, employee);
    }

    @Override
    public String toString() {
        return "UserAuthDTO{" +
                "username='" + username + '\'' +
                ", roles='" + roles + '\'' +
                ", active=" + active +
                ", employee=" + employee +
                '}';
    }
}
