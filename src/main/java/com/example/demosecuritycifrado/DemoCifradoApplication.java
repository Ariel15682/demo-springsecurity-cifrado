package com.example.demosecuritycifrado;

import com.example.demosecuritycifrado.services.Security;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;
import com.example.demosecuritycifrado.modelo.User;
import com.example.demosecuritycifrado.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * BCrypt que genera su propio salt de 16 bytes
 *
 * El resultado de cifrar con bcrypt sera un string de 60 caracteres
 *
 * comienza con "$a" que indica version
 * luego $10 que indica la fuerza (valor de 4 a 31, por defecto es 10) perdida de rendimiento-->mejora seguridad
 * Los 22 siguientes caracteres son el salt generado
 */

@SpringBootApplication
@ConfigurationPropertiesScan
public class DemoCifradoApplication {

    @Bean
    public PasswordEncoder passwordEncoder(){ //esto iria en una clase Security
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {

        //SpringApplication.run(DemoCifradoApplication.class, args); //ApplicationContext context = "lo que viene en el main"

        ApplicationContext context = SpringApplication.run(DemoCifradoApplication.class, args);

        UserRepository repository = context.getBean(UserRepository.class);

        PasswordEncoder encoder = context.getBean(PasswordEncoder.class);

        User admin = new User(null, "ariel_adm", "Password1234.");
        repository.save(admin);

        // Chequear los distintos encriptados para un mismo password
        int num=5;
        String[] hashedPassword = new String[num];
        for(int i=0; i < num; i++){

            hashedPassword[i] = encoder.encode(admin.getPassword());

            boolean matches = encoder.matches(admin.getPassword(), hashedPassword[i]);
            System.out.println("El password " + admin.getPassword() + " es igual a " + hashedPassword[i] + ": " + matches);
        }

        // Seteo el ultimo hash en admin password
        admin.setPassword(hashedPassword[num-1]);
        repository.save(admin);
        System.out.println("Asi queda el password 'Password1234.' encriptado: " + admin.getPassword());
    }

}