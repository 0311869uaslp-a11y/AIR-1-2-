package com.ecoalis.service;

import com.ecoalis.model.DemandeConge;
import com.ecoalis.model.Collaborateur;
import com.ecoalis.model.TypeDdc; // Importar TypeDdc
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class DemandeCongeServiceMock2 {
    
    @Autowired
    private CollaborateurRepository collaborateurRepository;
    
    private List<DemandeConge> demandes = new ArrayList<>();
    private Long nextId = 4L;
    
    public DemandeCongeServiceMock2() {
        // Inicializar con datos existentes
        Collaborateur c1 = new Collaborateur(1L, "Dupont", "Jean", "IT");
        Collaborateur c2 = new Collaborateur(2L, "Martin", "Marie", "RH");
        
        // CORRECCIÓN: Usar los valores correctos de TypeDdc
        demandes.add(new DemandeConge(1L, c1, new Date(), 5, TypeDdc.CONGE_PAYE));
        demandes.add(new DemandeConge(2L, c1, new Date(), 10, TypeDdc.RTT));
        demandes.add(new DemandeConge(3L, c2, new Date(), 7, TypeDdc.CONGE_SANS_SOLDE));
        
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
    
    public void creerDemande(DemandeConge demande) {
        System.out.println("Service: Création d'une nouvelle demande");
        
        // Générer un ID
        demande.setId(nextId++);
        
        // CORREGIDO: Verificar que collaborateur y su id no sean null
        if (demande.getCollaborateur() != null && demande.getCollaborateur().getId() != null) {
            Collaborateur fullCollab = collaborateurRepository.findById(demande.getCollaborateur().getId());
            if (fullCollab != null) {
                demande.setCollaborateur(fullCollab);
            }
        }
        
        demandes.add(demande);
        System.out.println("Demande créée avec ID: " + demande.getId());
    }
    
    public List<Collaborateur> getAllCollaborateurs() {
        return collaborateurRepository.findAll();
    }
}