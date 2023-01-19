package com.studentapp.service;

import com.studentapp.model.StudentEntity;
import com.studentapp.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentEntity saveStudent(StudentEntity student){
        return studentRepository.save(student);
    }

    public List<StudentEntity> getAllStudents(){
        return studentRepository.findAll();
    }
}
