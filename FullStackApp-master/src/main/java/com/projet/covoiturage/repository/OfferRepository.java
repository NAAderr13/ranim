package com.projet.covoiturage.repository;

import com.projet.covoiturage.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {
    // Vous pouvez ajouter des méthodes de recherche personnalisées si nécessaire.
}
