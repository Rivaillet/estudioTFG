package com.example.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name ="trans_auxiliar_content")
public class AuxiliarContent {

    @Id
    private Integer idAuxiliarContent;
    private Integer idSubject;
    private String contentName;
    private String link;
}
