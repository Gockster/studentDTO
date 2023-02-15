package com.example.stud.controllers;


import com.example.stud.entities.Student;
import com.example.stud.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<StudentDTO> getAll(){

        return studentService.getAllStudents();
    }

    @PostMapping("/new")
    public void registerNewStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteTheStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }


}
