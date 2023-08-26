package com.example.demosecuritycifrado.services;

import com.example.demosecuritycifrado.modelo.User;
import com.example.demosecuritycifrado.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInicializer implements CommandLineRunner {

    private final UserRepository repository;

    private final PasswordEncoder encoder;

    @Override
    public void run(String... args){

//        User admin = new User(null, "ariel_adm", encoder.encode("Password1234."));
//        repository.save(admin);
//
//        User user2 = User.builder()
//                .username("mod")
//                .password(encoder.encode("12345"))
//                .build();
//        repository.save(user2);
//
//        this.repository.save(User.builder()
//                .username("usuario")
//                .password(this.encoder.encode("1234"))
//                .build());
    }

}
