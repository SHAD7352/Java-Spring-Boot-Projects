package com.shad.controller;

import com.shad.model.Student;
import com.shad.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    // Getting all student data
    @GetMapping("")
    public List<Student> getStudents(){
        return studentService.getAllStudents();
    }

    // Getting single student data given by id
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Integer id){
        return studentService.getStudentById(id);
    }

    @PostMapping("/store")
    public Student saveStudent(@RequestBody Student student){
        return studentService.create(student);
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student){
        return studentService.update(student);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id){
        return studentService.deleteStudent(id);
    }
}
