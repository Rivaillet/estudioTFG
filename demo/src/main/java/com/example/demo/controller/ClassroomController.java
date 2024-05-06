package com.example.demo.controller;

import com.example.demo.entity.Classroom;
import com.example.demo.service.ClassroomService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("api/classrooms")
public class ClassroomController {


    @Autowired
    private ClassroomService classroomService;

    @GetMapping("/allClasses")
    public ResponseEntity<List<Classroom>> getAllClassrooms(){

        List<Classroom> classrooms = classroomService.getAllClassrooms();
        return new ResponseEntity<>(classrooms,HttpStatus.OK);
    }

}
