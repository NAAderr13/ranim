package com.projet.covoiturage.controller;

import com.projet.covoiturage.model.Offer;
import com.projet.covoiturage.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/offers")
@CrossOrigin(origins = "http://localhost:3000") // Si votre frontend est sur un autre port
public class OfferController {

    @Autowired
    private OfferService offerService;

    // Endpoint pour créer une nouvelle offre
    @PostMapping
    public ResponseEntity<?> createOffer(@RequestBody Offer offer) {
        try {
            Offer savedOffer = offerService.saveOffer(offer);
            return new ResponseEntity<>(savedOffer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de l'enregistrement de l'offre", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint pour obtenir une offre par son identifiant
    @GetMapping("/{id}")
    public ResponseEntity<?> getOffer(@PathVariable Long id) {
        Optional<Offer> offer = offerService.getOffer(id);
        if (offer.isPresent()) {
            return new ResponseEntity<>(offer.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Offre non trouvée", HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour obtenir toutes les offres
    @GetMapping
    public List<Offer> getAllOffers() {
        return offerService.getAllOffers();
    }
}
