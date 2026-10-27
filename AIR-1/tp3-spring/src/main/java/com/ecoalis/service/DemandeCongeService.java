package com.ecoalis.service;

import com.ecoalis.model.DemandeConge;
import com.ecoalis.dao.DemandeCongeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  // Anotación ESPECÍFICA para servicios
public class DemandeCongeService {
    
    @Autowired
    private DemandeCongeDao demandeCongeDao;
    
    public void creerDemande(DemandeConge demande) {
        System.out.println("Service: Création d'une demande de congé");
        System.out.println("  Pour: " + demande.getCollaborateur().getNom());
        System.out.println("  Période: " + demande.getPeriode().getNbJours() + " jours");
        
        demandeCongeDao.save(demande);
        System.out.println("  Demande enregistrée. Total: " + demandeCongeDao.count());
    }
    
    public void approuverDemande(int id) {
        // En una app real, buscaríamos por ID
        System.out.println("Service: Demande approuvée (simulation)");
    }
    
    public int getNombreDemandes() {
        return demandeCongeDao.count();
    }
}