package com.example.demosecuritycifrado.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){ //esto va en na clase security
        return new BCryptPasswordEncoder();
    }

}