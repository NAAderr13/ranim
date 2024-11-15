package com.ndrcodes.studentsystem.repository;

import com.ndrcodes.studentsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByEmail(String email); // Méthode pour trouver un étudiant par email
}
