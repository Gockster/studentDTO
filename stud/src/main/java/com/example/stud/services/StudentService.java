package com.example.stud.services;

import com.example.stud.controllers.StudentDTO;
import com.example.stud.dao.StudentRepository;
import com.example.stud.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<StudentDTO> getAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        return studentList
                .stream()
                .map(this::fromEntityToDto)
                .collect(Collectors.toList());
    }

    public StudentDTO fromEntityToDto(Student student){
        return new StudentDTO(student.getId(),
                                student.getName(),
                                student.getEmail());
    }

    public void addStudent(Student student) {
//        Optional<Student> studentByEmail = studentRepository.findByEmail(student.getEmail());
//
//        if (studentByEmail.isPresent()) {
//            throw new IllegalStateException("Email token");
//        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId){
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("The id not exists");
        }
        studentRepository.deleteById(studentId);

    }
}
