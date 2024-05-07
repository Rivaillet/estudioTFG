package com.example.ProyectoJuanBarberoSerrano.services;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.example.ProyectoJuanBarberoSerrano.entities.AuxiliarContent;
import com.example.ProyectoJuanBarberoSerrano.repositories.AuxiliarContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;
import java.util.List;

@Service
public class AuxiliarContentServiceImpl implements AuxiliarContentService{

    @Autowired
    private AuxiliarContentRepository auxiliarContentRepository;

    @Autowired
    private S3Service s3Service;

    @Override
    public List<String> getAllAuxiliarContentLinks() {

        return List.of();
    }

    @Override
    public void putAuxiliarContent(MultipartFile multipartFile) {
        AuxiliarContent auxiliarContent = new AuxiliarContent();
        auxiliarContent.setContentName(multipartFile.getOriginalFilename());
        auxiliarContent.setIdSubject(1);
        auxiliarContent.setLink(s3Service.uploadFileToS3(multipartFile.getOriginalFilename(),multipartFile));
        auxiliarContentRepository.save(auxiliarContent);

    }

    @Override
    public List<AuxiliarContent> getAllAuxiliarContent() {
        List<AuxiliarContent> list = auxiliarContentRepository.findAll();
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).getLink()+"========================");
        }
        return auxiliarContentRepository.findAll();
    }


}
