package com.projet.covoiturage.service;

import com.projet.covoiturage.model.user;

import java.util.List;

public interface userService {

    // Enregistrer ou mettre à jour un utilisateur
    void saveUser(user user);

    // Obtenir tous les utilisateurs
    List<user> getAllUsers();

    // Trouver un utilisateur par email
    user findByEmail(String email);

    // Trouver un utilisateur par ID
    user findById(Long id);

    // Supprimer un utilisateur par ID
    void deleteUser(Long id);
}
