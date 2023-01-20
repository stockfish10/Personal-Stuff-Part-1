package com.studentapp.web;

import com.studentapp.model.StudentEntity;
import com.studentapp.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public String addStudent(@RequestBody StudentEntity student){
        studentService.saveStudent(student);
        return "New student is added";
    }

    @GetMapping("/getAll")
    public List<StudentEntity> getAllStudents(){
        return studentService.getAllStudents();
    }

}
