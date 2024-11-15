package com.ndrcodes.studentsystem.service;

import com.ndrcodes.studentsystem.model.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);
    List<Student> getAllStudents();
    Student findByEmail(String email);
}
