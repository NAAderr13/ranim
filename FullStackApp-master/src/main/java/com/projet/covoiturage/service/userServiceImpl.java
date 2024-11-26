package com.projet.covoiturage.service;

import com.projet.covoiturage.model.user;
import com.projet.covoiturage.repository.covRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class covServiceImpl implements covService {

    @Autowired
    private covRepository studentRepository;

    @Override
    public void saveStudent(user User) {

    }

    @Override
    public void saveUser(user User) {
        studentRepository.save(User);
    }

    @Override
    public List<user> getAllUsers() {
        return List.of();
    }

    @Override
    public List<user> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public user findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

}
