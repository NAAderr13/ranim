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
    public user saveStudent(user student) {
        return studentRepository.save(student);
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
