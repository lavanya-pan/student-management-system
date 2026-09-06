package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentEntity saveStudent(StudentEntity student) {
        return studentRepository.save(student);
    }

    @Cacheable(value = "students")
    public List<StudentEntity> getAllStudents() {
        System.out.println("Fetching from DATABASE...");
        return studentRepository.findAll();
    }

    @Cacheable(value = "student", key = "#id")
    public StudentEntity getStudentById(Long id) {
        System.out.println("Fetching student " + id + " from DATABASE...");
        return studentRepository.findById(id).orElse(null);
    }

    @CacheEvict(value = {"students", "student"}, allEntries = true)
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @CacheEvict(value = {"students", "student"}, allEntries = true)
    public StudentEntity updateStudent(Long id, StudentEntity updatedStudent) {
        StudentEntity existing = studentRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(updatedStudent.getName());
            existing.setCollege(updatedStudent.getCollege());
            existing.setCgpa(updatedStudent.getCgpa());
            return studentRepository.save(existing);
        }
        return null;
    }
}