package com.projet.covoiturage.service;

import com.projet.covoiturage.model.user;

import java.util.List;

public interface covService {
    void saveStudent(user student);
    List<user> getAllStudents();

 


    user findByEmail(String email);

    user findById(Long id);

    void deleteUser(Long id);
}
