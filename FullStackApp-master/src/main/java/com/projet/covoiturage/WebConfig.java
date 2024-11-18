package com.projet.covoiturage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Appliquer CORS sur toutes les routes
                .allowedOrigins("http://localhost:3000") // Permet les requêtes venant de React (localhost:3000)
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Méthodes HTTP autorisées
                .allowedHeaders("*") // Accepte tous les en-têtes
                .allowCredentials(true); // Autorise l'envoi de cookies (si nécessaire)
    }
}
