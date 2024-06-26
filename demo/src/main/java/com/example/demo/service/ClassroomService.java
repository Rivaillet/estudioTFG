package com.example.demo.service;

import com.example.demo.entity.Classroom;
import com.example.demo.entity.User;
import com.example.demo.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ClassroomService {

    List<Classroom> getAllClassrooms();

}
