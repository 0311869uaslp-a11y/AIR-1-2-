package com.ecoalis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class DemandeCongeQualifierPrincipal {
    
    @Autowired
    @Qualifier("principal")  // Inyecta ESPECÍFICAMENTE el bean con qualifier="principal"
    private Collaborateur collaborateur;
    
    @Autowired
    private Periode periode;  // No necesita @Qualifier (solo hay un Periode)

    public Collaborateur getCollaborateur() {
        return collaborateur;
    }
    
    public Periode getPeriode() {
        return periode;
    }

    @Override
    public String toString() {
        return "DemandeCongeQualifierPrincipal{" +
               "collaborateur=" + (collaborateur != null ? 
                   collaborateur.getNom() + " " + collaborateur.getPrenom() : "null") +
               ", periode=" + (periode != null ? 
                   periode.getDateDebut() + " (" + periode.getNbJours() + " jours)" : "null") +
               '}';
    }
}