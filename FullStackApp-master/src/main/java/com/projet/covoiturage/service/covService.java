package com.projet.covoiturage.service;

import com.projet.covoiturage.model.user;

import java.util.List;

public interface covService {
    user saveStudent(user student);
    List<user> getAllStudents();
    user findByEmail(String email);
}
