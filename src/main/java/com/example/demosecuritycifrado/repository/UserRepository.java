package com.example.demosecuritycifrado.repository;

import com.example.demosecuritycifrado.modelo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> { //extiende de JpaRepository(Clase, id)
}
