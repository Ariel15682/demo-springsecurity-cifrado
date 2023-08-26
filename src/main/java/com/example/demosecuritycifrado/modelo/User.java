package com.example.demosecuritycifrado.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "app_users")//poner un nombre compuesto para que no genere problemas con base de datos de igual nombre
//@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
//@Builder
//@Value // igual a Data pero inmutable, todos los campos privados y finales
//@Data //  un constructor que inicializa los campos finales y no finales marcados con NonNull, getter/setter, to String
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Incluir el strategy IDENTITY
    @Getter
    private Long id;

    //@Setter
    @Getter
    @NonNull
    private String username;

    @Setter
    @Getter
    @NonNull
    private String password;

}