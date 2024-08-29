package com.example.SpringSecutity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
                            authorizeHttp.requestMatchers("/error").permitAll();
                            authorizeHttp.anyRequest().authenticated();
                        }
                )
                .formLogin(l-> {
                    l.defaultSuccessUrl("/private");
//                  l.failureHandler(new LoginFormAuthenticateHandleError());
                })
                .logout(l -> l.logoutSuccessUrl("/"))
                .authenticationProvider(new CustomDaoProvider())
                .addFilterAfter(new ExampleFilter(), UsernamePasswordAuthenticationFilter.class)
                .build();
    }
//    public UserDetailsService userDetailsService(){
//        User.UserBuilder users = User.withDefaultPasswordEncoder() ;
//        UserDetails userDetails = users
//                .username("Thanh-Nhan")
//                .password("123")
//                .roles("User")
//                .build();
//        return new InMemoryUserDetailsManager(userDetails);
//    }
//    @Bean
//    public DaoAuthenticationProvider inMemoryDaoAuthenticationProvider(){
//        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
//        return daoAuthenticationProvider;
//    }
}
