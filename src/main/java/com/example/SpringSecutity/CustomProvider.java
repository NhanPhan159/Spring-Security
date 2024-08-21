package com.example.SpringSecutity;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;

import java.util.Objects;

public class CustomProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        var name = authentication.getName();
        if(Objects.equals(name,"nhan")){
            var nhan = User.withUsername("nhan")
                    .password("default")
                    .roles("user", "admin")
                    .build();
            return UsernamePasswordAuthenticationToken.authenticated(
                    nhan,
                    null,
                    nhan.getAuthorities());
        }
        throw new BadCredentialsException("Invalid user or password");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
