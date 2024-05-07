package com.example.ProyectoJuanBarberoSerrano.controllers;

import com.example.ProyectoJuanBarberoSerrano.entities.AuxiliarContent;
import com.example.ProyectoJuanBarberoSerrano.services.AuxiliarContentService;
import com.example.ProyectoJuanBarberoSerrano.services.AuxiliarContentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@AllArgsConstructor



@CrossOrigin("*")



@RequestMapping("api/auxiliarContent")
public class AuxiliarContentController {

    @Autowired
    private AuxiliarContentServiceImpl auxiliarContentService;

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("archivo") MultipartFile archivo) {
        if (archivo.isEmpty()) {
            return "Archivo no seleccionado";
        }
        try {
            // Aquí puedes realizar cualquier operación con el archivo, como guardarlo en el sistema de archivos, base de datos, etc.
            // En este ejemplo, simplemente mostramos el nombre del archivo:
            System.out.print(archivo.getOriginalFilename());
            auxiliarContentService.putAuxiliarContent(archivo);
            return "Archivo subido correctamente: " + archivo.getOriginalFilename();

        } catch (Exception e) {
            System.out.print(" CONTROLLER AUXILIARCONTENT ERRORRRRRRRRRRRRR");
            return "Error al subir el archivo: " + e.getMessage();
        }
    }

    @GetMapping("/getAll")
    private List<AuxiliarContent> getAllAuxiliarContent(){


        return auxiliarContentService.getAllAuxiliarContent();
    }



}
