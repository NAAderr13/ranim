package com.projet.covoiturage.repository;

import com.projet.covoiturage.model.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface covRepository extends JpaRepository<user, Long> {
    user findByEmail(String email); // Méthode pour trouver un étudiant par email
}
