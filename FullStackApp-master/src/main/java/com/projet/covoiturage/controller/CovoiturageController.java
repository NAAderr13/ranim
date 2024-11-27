package com.projet.covoiturage.controller;

import com.projet.covoiturage.model.user;
import com.projet.covoiturage.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user") // Changement du mapping principal
@CrossOrigin
public class CovoiturageController {

    @Autowired
    private userService userService; // Mise à jour du service

    @PostMapping("/add")
    public String add(@RequestBody user user) {
        userService.saveUser(user);
        return "New user is added";
    }

    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> signUp(@RequestBody user user) {
        Map<String, Object> response = new HashMap<>();
        String email = user.getEmail();
        String password = user.getPassword();
        String name = user.getName();

        // Vérifie si l'utilisateur existe déjà
        if (userService.findByEmail(email) != null) {
            response.put("success", false);
            response.put("message", "L'utilisateur existe déjà.");
            return ResponseEntity.badRequest().body(response); // Renvoie une erreur 400
        }

        // Logique d'inscription de l'utilisateur
        userService.saveUser(user);
        response.put("success", true);
        response.put("message", "Inscription réussie !");
        return ResponseEntity.ok(response); // Renvoie une réponse 200 OK
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody user user) {
        String email = user.getEmail();
        String password = user.getPassword();

        // Debug : afficher les informations reçues
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        // Vérifie si l'utilisateur existe
        user existingUser = userService.findByEmail(email);

        Map<String, Object> response = new HashMap<>();

        if (existingUser != null && existingUser.getPassword().equals(password)) {
            response.put("success", true);
            response.put("message", "Sign in successful");
            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            response.put("message", "Invalid email or password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    @GetMapping("/get")
    public List<user> list() {
        return userService.getAllUsers();
    }

    // Mise à jour d'un utilisateur par ID
    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updateUser(@PathVariable Long id, @RequestBody user user) {
        Map<String, Object> response = new HashMap<>();
        user existingUser = userService.findById(id);

        if (existingUser == null) {
            response.put("success", false);
            response.put("message", "Utilisateur introuvable");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        // Mise à jour des informations de l'utilisateur
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword()); // Assurez-vous de gérer correctement les mots de passe

        userService.saveUser(existingUser); // Sauvegarder les modifications

        response.put("success", true);
        response.put("message", "Utilisateur mis à jour avec succès");
        return ResponseEntity.ok(response);
    }

    // Suppression d'un utilisateur par ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteUser(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        user existingUser = userService.findById(id);

        if (existingUser == null) {
            response.put("success", false);
            response.put("message", "Utilisateur introuvable");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        // Supprimer l'utilisateur
        userService.deleteUser(id);

        response.put("success", true);
        response.put("message", "Utilisateur supprimé avec succès");
        return ResponseEntity.ok(response);
    }
}
