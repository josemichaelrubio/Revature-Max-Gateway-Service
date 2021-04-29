package dev.revaturemax.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class LoginUserDetails implements UserDetails {

    private String username;
    private String password;
    private List<GrantedAuthority> roles;
    private boolean active;
    private int employeeID;

    public LoginUserDetails(UserAuth userAuth) {
        this.username = userAuth.getUsername();
        this.password = userAuth.getPassword();
        if(userAuth.getRoles()!=null)
            this.roles = Stream.of(userAuth.getRoles().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        else
            this.roles = new ArrayList<>();
        this.active = userAuth.isActive();
        this.employeeID = userAuth.getEmployee();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return active;
    }

    @Override
    public boolean isAccountNonLocked() {
        return active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return active;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
