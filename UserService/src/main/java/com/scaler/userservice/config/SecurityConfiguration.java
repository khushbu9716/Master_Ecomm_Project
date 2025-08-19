package com.scaler.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests((authorize) -> authorize
////                        .requestMatchers("/auth/signup").permitAll() // Allow public access to /public/**
//                        .anyRequest().permitAll() // All other requests require authentication
//                );
//
//        return http.build();
//    }
}
