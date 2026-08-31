package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public StudentEntity saveStudent(@RequestBody StudentEntity student) {
        return studentService.saveStudent(student);
    }

    @GetMapping("/all")
    public List<StudentEntity> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public StudentEntity getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "Student deleted successfully!";
    }
    @PutMapping("/student/{id}")
    public StudentEntity updateStudent(@PathVariable Long id, @RequestBody StudentEntity student) {
        return studentService.updateStudent(id, student);
    }
}