package com.ecoalis.model;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Component  // Otro componente detectado automáticamente
public class Periode {
    
    @Value("2025-01-01")
    private String dateDebut;
    
    @Value("10")
    private int nbJours;
    
    // Constructores
    public Periode() {}
    
    public Periode(String dateDebut, int nbJours) {
        this.dateDebut = dateDebut;
        this.nbJours = nbJours;
    }
    
    // Getters y Setters
    public String getDateDebut() { return dateDebut; }
    public void setDateDebut(String dateDebut) { this.dateDebut = dateDebut; }
    
    public int getNbJours() { return nbJours; }
    public void setNbJours(int nbJours) { this.nbJours = nbJours; }
    
    @Override
    public String toString() {
        return "Periode [dateDebut=" + dateDebut + ", nbJours=" + nbJours + "]";
    }
}