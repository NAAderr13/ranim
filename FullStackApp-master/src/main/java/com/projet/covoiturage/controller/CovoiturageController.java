package com.projet.covoiturage.controller;

import com.projet.covoiturage.model.user;
import com.projet.covoiturage.service.covService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class CovoiturageController {
    @Autowired
    private covService studentService;

    @PostMapping("/add")
    public String add(@RequestBody user student){
        studentService.saveStudent(student);
        return "New student is added";
    }

    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> signUp(@RequestBody user student) {
        Map<String, Object> response = new HashMap<>();
        String email = student.getEmail();
        String password = student.getPassword();
        String name = student.getName();

        // Vérifiez si l'utilisateur existe déjà
        if (studentService.findByEmail(email) != null) {
            response.put("success", false);
            response.put("message", "L'utilisateur existe déjà.");
            return ResponseEntity.badRequest().body(response); // Renvoie une erreur 400
        }

        // Logique d'inscription de l'utilisateur ici (ajouter à la base de données)
        studentService.saveStudent(student);
        response.put("success", true);
        response.put("message", "Inscription réussie !");
        return ResponseEntity.ok(response); // Renvoie une réponse 200 OK
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody user student) {
        String email = student.getEmail();
        String password = student.getPassword();

        // Debug : afficher les informations reçues
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        // Vérifiez si l'utilisateur existe
        user existingStudent = studentService.findByEmail(email);

        Map<String, Object> response = new HashMap<>();

        if (existingStudent != null && existingStudent.getPassword().equals(password)) {
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
    public List<user> list(){
        return studentService.getAllStudents();
    }
}
