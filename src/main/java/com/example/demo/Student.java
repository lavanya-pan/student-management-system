package com.example.demo;

public class Student {
    private String name;
    private String college;
    private double cgpa;

    public Student(String name, String college, double cgpa) {
        this.name = name;
        this.college = college;
        this.cgpa = cgpa;
    }

    public String getName() { return name; }
    public String getCollege() { return college; }
    public double getCgpa() { return cgpa; }
}