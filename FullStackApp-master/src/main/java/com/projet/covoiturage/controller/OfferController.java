package com.projet.covoiturage.controller;

import com.projet.covoiturage.model.Offer;
import com.projet.covoiturage.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/offer")
public class OfferController {

    @Autowired
    private OfferService offerService;

    // Recherche des offres par destination et lieu de départ
    @GetMapping("/search")
    public ResponseEntity<?> searchOffers(
            @RequestParam(value = "destination") String destination,
            @RequestParam(value = "startingLocation") String startingLocation) {

        // Recherche dans la base de données
        List<Offer> offers = offerService.findOffersByDestinationAndStartingLocation(destination, startingLocation);

        if (offers.isEmpty()) {
            return ResponseEntity.status(404).body("Aucune offre trouvée pour ces critères.");
        }

        return ResponseEntity.ok(offers); // Renvoie les offres trouvées
    }

    // Création d'une nouvelle offre
    @PostMapping
    public ResponseEntity<?> createOffer(@RequestBody Offer offer) {
        // Vérification des champs obligatoires
        if (offer.getStartingLocation() == null || offer.getDestination() == null || offer.getDate() == null) {
            return ResponseEntity.badRequest().body("Tous les champs obligatoires doivent être remplis");
        }

        // Sauvegarde de l'offre
        offerService.saveOffer(offer);

        return ResponseEntity.ok("Offre enregistrée avec succès");
    }
}
