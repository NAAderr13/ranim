package com.projet.covoiturage.service;

import com.projet.covoiturage.model.user;
import com.projet.covoiturage.repository.covRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userServicelmpl implements userService {

    @Autowired
    private covRepository userRepository; // Remplacement de studentRepository par userRepository

    // Enregistrer ou mettre à jour un utilisateur
    @Override
    public void saveUser(user user) {
        userRepository.save(user);
    }

    // Récupérer tous les utilisateurs
    @Override
    public List<user> getAllUsers() { // Remplacement de getAllStudents par getAllUsers
        return userRepository.findAll();
    }

    // Trouver un utilisateur par son email
    @Override
    public user findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Trouver un utilisateur par son ID
    @Override
    public user findById(Long id) {
        Optional<user> user = userRepository.findById(id);
        return user.orElse(null); // Retourne null si l'utilisateur n'est pas trouvé
    }

    // Supprimer un utilisateur par son ID
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
