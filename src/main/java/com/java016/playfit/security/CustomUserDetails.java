package com.java016.playfit.security;

import com.java016.playfit.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {
    private String fullName;
    private String password;
    private Integer id;
    private List<GrantedAuthority> authorities;

    public CustomUserDetails(User user) {
        this.fullName = user.getFullName();
        this.password = user.getPassword();
        this.id = user.getId();
        String roles = user.getRole();
        if (roles == null) {
            roles = "ROLE_DEF";
        }

        this.authorities = (List) Arrays.stream(roles.split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }


    public Integer getId() {
        return id;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.fullName;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }
}
