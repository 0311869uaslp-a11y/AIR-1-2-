package com.ecoalis.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;  // ← ¡AGREGA ESTA LÍNEA!

@Component
public class DemandeConge {
    
    @Autowired  // Spring inyectará automáticamente
    private Collaborateur collaborateur;
    
    @Autowired  // Spring inyectará automáticamente
    private Periode periode;
    
    @Value("EN_ATTENTE")
    private String statut;
    
    // Constructores
    public DemandeConge() {}
    
    public DemandeConge(Collaborateur collaborateur, Periode periode) {
        this.collaborateur = collaborateur;
        this.periode = periode;
        this.statut = "EN_ATTENTE";
    }
    
    // Getters y Setters
    public Collaborateur getCollaborateur() { return collaborateur; }
    public void setCollaborateur(Collaborateur collaborateur) { this.collaborateur = collaborateur; }
    
    public Periode getPeriode() { return periode; }
    public void setPeriode(Periode periode) { this.periode = periode; }
    
    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }
    
    // Método de negocio
    public void approuver() {
        this.statut = "APPROUVEE";
    }
    
    public void rejeter() {
        this.statut = "REJETEE";
    }
    
    @Override
    public String toString() {
        return "DemandeConge [collaborateur=" + collaborateur + 
               ", periode=" + periode + ", statut=" + statut + "]";
    }
}