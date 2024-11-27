package com.projet.covoiturage.service;

import com.projet.covoiturage.model.Offer;
import com.projet.covoiturage.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    // Sauvegarder une nouvelle offre
    public void saveOffer(Offer offer) {
        offerRepository.save(offer);
    }

    // Trouver les offres par destination et lieu de départ
    public List<Offer> findOffersByDestinationAndStartingLocation(String destination, String startingLocation) {
        return offerRepository.findByDestinationAndStartingLocation(destination, startingLocation);
    }
}
