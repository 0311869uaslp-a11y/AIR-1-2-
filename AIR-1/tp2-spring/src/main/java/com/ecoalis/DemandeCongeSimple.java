package com.ecoalis;

import org.springframework.beans.factory.annotation.Autowired;

public class DemandeCongeSimple {
    
    @Autowired
    private Collaborateur collaborateur;  // SIN @Qualifier - ¿Cuál inyectará?
    
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
        return "DemandeCongeSimple{" +
               "collaborateur=" + (collaborateur != null ? 
                   collaborateur.getNom() + " " + collaborateur.getPrenom() : "null") +
               ", periode=" + (periode != null ? 
                   periode.getDateDebut() + " (" + periode.getNbJours() + " jours)" : "null") +
               '}';
    }
}