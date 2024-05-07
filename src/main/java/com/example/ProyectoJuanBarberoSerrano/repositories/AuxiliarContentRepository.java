package com.example.ProyectoJuanBarberoSerrano.repositories;

import com.example.ProyectoJuanBarberoSerrano.entities.AuxiliarContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuxiliarContentRepository extends JpaRepository<AuxiliarContent, Integer> {


}
