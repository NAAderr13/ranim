package com.projet.covoiturage.service;

import com.projet.covoiturage.model.Offer;
import com.projet.covoiturage.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    // Méthode pour enregistrer une nouvelle offre
    public Offer saveOffer(Offer offer) {
        // Vous pouvez ajouter des validations ou des transformations supplémentaires ici
        return offerRepository.save(offer);
    }

    // Méthode pour obtenir une offre par son identifiant
    public Optional<Offer> getOffer(Long id) {
        return offerRepository.findById(id);
    }
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    // Vous pouvez ajouter d'autres méthodes pour gérer les offres (ex. récupérer toutes les offres)
}
