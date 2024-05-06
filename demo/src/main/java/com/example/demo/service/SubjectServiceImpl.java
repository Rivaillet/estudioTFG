package com.example.demo.service;

import com.example.demo.entity.Subject;
import com.example.demo.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService{

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public List<Subject> getSubjectsByIdClassroom(Integer idClassroom) {
        return subjectRepository.findByIdClassroom(idClassroom);
    }
}
