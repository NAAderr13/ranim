package com.projet.covoiturage.service;

import com.projet.covoiturage.model.user;
import com.projet.covoiturage.repository.covRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class covServiceImpl implements covService {

    @Autowired
    private covRepository studentRepository;

    // Enregistrer ou mettre à jour un utilisateur
    @Override
    public void saveStudent(user student) {
        studentRepository.save(student);
    }

    // Récupérer tous les utilisateurs
    @Override
    public List<user> getAllStudents() {
        return studentRepository.findAll();
    }

    // Trouver un utilisateur par son email
    @Override
    public user findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    // Trouver un utilisateur par son ID
    public user findById(Long id) {
        Optional<user> student = studentRepository.findById(id);
        return student.orElse(null); // Retourne null si l'utilisateur n'est pas trouvé
    }

    // Supprimer un utilisateur par son ID
    public void deleteUser(Long id) {
        studentRepository.deleteById(id);
    }
}
