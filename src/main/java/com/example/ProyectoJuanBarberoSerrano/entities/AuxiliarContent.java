package com.example.ProyectoJuanBarberoSerrano.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "trans_auxiliar_content")
public class AuxiliarContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAuxiliarContent;
    private int idSubject;
    private String contentName;
    private String link;

}
