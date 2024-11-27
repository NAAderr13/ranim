package com.projet.covoiturage.repository;

import com.projet.covoiturage.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Long> {
    List<Offer> findByDestinationAndStartingLocation(String destination, String startingLocation);
    // Ici tu peux ajouter des méthodes de recherche spécifiques si nécessaire
}
