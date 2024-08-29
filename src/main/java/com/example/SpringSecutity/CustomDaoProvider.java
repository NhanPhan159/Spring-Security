package com.example.SpringSecutity;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

@Component
public class CustomDaoProvider extends DaoAuthenticationProvider {

    public CustomDaoProvider(){
        super();
        this.setUserDetailsService(userDetailsService());
        this.setMessageSource();

   }
    public UserDetailsService userDetailsService(){
        User.UserBuilder users = User.withDefaultPasswordEncoder() ;
        UserDetails userDetails = users
                .username("Thanh-Nhan")
                .password("123")
                .roles("User")
                .build();
        UserDetails userDetails1 = users
                .username("Thanh-Nghia")
                .password("123")
                .roles("User")
                .build();
        return new InMemoryUserDetailsManager(userDetails,userDetails1);
    }
}

