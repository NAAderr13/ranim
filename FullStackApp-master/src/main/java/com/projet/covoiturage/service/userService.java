package com.projet.covoiturage.service;

import com.projet.covoiturage.model.user;

import java.util.List;

public interface covService {
    void saveStudent(user User);

    void saveUser(user User);

    List<user> getAllUsers();

    List<user> getAllStudents();

    user findByEmail(String email);
}
