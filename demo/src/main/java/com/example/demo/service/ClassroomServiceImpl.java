package com.example.demo.service;

import com.example.demo.entity.Classroom;
import com.example.demo.repository.ClassroomRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class ClassroomServiceImpl implements ClassroomService{

    @Autowired
    private ClassroomRepository classroomRepository;
    @Override
    public List<Classroom> getAllClassrooms() {
        
        return StreamSupport.stream(classroomRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
