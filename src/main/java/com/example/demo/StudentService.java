package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentEntity saveStudent(StudentEntity student) {
        return studentRepository.save(student);
    }

    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    public StudentEntity getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
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