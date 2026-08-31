package com.example.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String college;
    private double cgpa;

    public StudentEntity() {}

    public StudentEntity(String name, String college, double cgpa) {
        this.name = name;
        this.college = college;
        this.cgpa = cgpa;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getCollege() { return college; }
    public double getCgpa() { return cgpa; }
    public void setName(String name) { this.name = name; }
    public void setCollege(String college) { this.college = college; }
    public void setCgpa(double cgpa) { this.cgpa = cgpa; }
}