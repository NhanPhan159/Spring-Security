package com.example.SpringSecutity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(
                        authorizeHttp -> {
                            authorizeHttp.requestMatchers("/").permitAll();
                            authorizeHttp.requestMatchers("/css/*").permitAll();
                            authorizeHttp.requestMatchers("/private").authenticated();
                        }
                )
                .formLogin(l-> {
                    l.defaultSuccessUrl("/private");
//                  l.failureHandler(new LoginFormAuthenticateHandleError());
                })
                .authenticationProvider(new CustomProvider())
                .addFilterAfter(new ExampleFilter(), UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
