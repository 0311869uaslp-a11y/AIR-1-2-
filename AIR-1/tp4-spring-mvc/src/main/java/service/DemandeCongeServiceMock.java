package com.ecoalis.service;

import com.ecoalis.model.DemandeConge;
import com.ecoalis.model.Collaborateur;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class DemandeCongeServiceMock {
    
    private List<DemandeConge> demandes = new ArrayList<>();
    
    public DemandeCongeServiceMock() {
        // Datos de prueba - usar constructor correcto
        Collaborateur c1 = new Collaborateur(1L, "Dupont", "Jean", "IT");
        Collaborateur c2 = new Collaborateur(2L, "Martin", "Marie", "RH");
        
        // Usar constructor con Date, no String
        demandes.add(new DemandeConge(1L, c1, new Date(), 5, null));
        demandes.add(new DemandeConge(2L, c1, new Date(), 10, null));
        demandes.add(new DemandeConge(3L, c2, new Date(), 7, null));
        
        // Opcional: agregar comentarios
        demandes.get(0).setCommentaire("Vacances d'été");
        demandes.get(1).setCommentaire("Formation");
        demandes.get(2).setCommentaire("Rendez-vous médical");
    }
    
    public List<DemandeConge> getAllDemandes() {
        return new ArrayList<>(demandes);
    }
    
    public DemandeConge getDemandeById(Long id) {
        return demandes.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    
    public int getNombreDemandes() {
        return demandes.size();
    }
}