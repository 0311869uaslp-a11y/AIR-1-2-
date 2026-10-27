package com.ecoalis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class DemandeCongeQualifierSecundario {
    
    @Autowired
    @Qualifier("secundario")  // Inyecta ESPECÍFICAMENTE el bean con qualifier="secundario"
    private Collaborateur collaborateur;
    
    @Autowired
    private Periode periode;

    public Collaborateur getCollaborateur() {
        return collaborateur;
    }
    
    public Periode getPeriode() {
        return periode;
    }

    @Override
    public String toString() {
        return "DemandeCongeQualifierSecundario{" +
               "collaborateur=" + (collaborateur != null ? 
                   collaborateur.getNom() + " " + collaborateur.getPrenom() : "null") +
               ", periode=" + (periode != null ? 
                   periode.getDateDebut() + " (" + periode.getNbJours() + " jours)" : "null") +
               '}';
    }
}