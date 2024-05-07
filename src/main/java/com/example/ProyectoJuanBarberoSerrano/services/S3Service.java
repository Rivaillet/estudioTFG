package com.example.ProyectoJuanBarberoSerrano.services;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class S3Service {

    private  AmazonS3 s3Client;
    private final String bucketName = "aulavirtualtfg";
    private BasicAWSCredentials awsCredentials;
    @Value("${aws.access-key}")
    private String awsAccessKey;
    @Value("${aws.region}")
    private String awsRegion;
    @Value("${aws.secret-key}")
    private String awsSecretKey;

    public S3Service(){

    }

    @PostConstruct
    public void init() {
        awsCredentials = new BasicAWSCredentials(awsAccessKey, awsSecretKey);
        this.s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .withRegion(awsRegion)
                .build();

    }


    public String uploadFileToS3( String fileName , MultipartFile file){


        try{

            PutObjectRequest request = new PutObjectRequest(bucketName,fileName, file.getInputStream(),null);

            s3Client.putObject(request);

            return s3Client.getUrl(bucketName,fileName).toString();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al cargar el archivo en S3: " + e.getMessage());
        }

    }
}
