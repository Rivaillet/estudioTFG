package com.example.ProyectoJuanBarberoSerrano.services;


import com.example.ProyectoJuanBarberoSerrano.entities.AuxiliarContent;
import com.example.ProyectoJuanBarberoSerrano.repositories.AuxiliarContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AuxiliarContentService  {

    public List<String> getAllAuxiliarContentLinks();
    public void putAuxiliarContent(MultipartFile multipartFile);
    public List<AuxiliarContent> getAllAuxiliarContent();

}
