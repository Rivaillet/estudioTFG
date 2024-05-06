package com.example.demo.controller;

import com.example.demo.entity.Subject;
import com.example.demo.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("api/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/{idClassroom}")
    private List<Subject> getSubjectsByIdClassroom(@PathVariable("idClassroom")Integer idClassroom){

        return subjectService.getSubjectsByIdClassroom(idClassroom);
    }

}
