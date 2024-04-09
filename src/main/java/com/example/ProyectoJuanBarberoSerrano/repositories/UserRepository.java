package com.example.ProyectoJuanBarberoSerrano.repositories;

import com.example.ProyectoJuanBarberoSerrano.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByFirstName(String firstName);

    

}
