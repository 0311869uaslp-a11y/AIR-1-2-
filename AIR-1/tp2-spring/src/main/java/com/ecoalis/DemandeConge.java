package com.ecoalis;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;

public class DemandeConge {
    // Para autowiring byName
    private Collaborateur c;
    private Periode p;
    
    // Para @Autowired
    @Autowired
    private Collaborateur collaborateur;
    
    @Autowired
    private Periode periode;

    public DemandeConge() {}

    // Setters para autowiring byName
    public void setC(Collaborateur c) {
        this.c = c;
    }
    
    public void setP(Periode p) {
        this.p = p;
    }
    
    // Getters para pruebas
    public Collaborateur getC() {
        return c;
    }
    
    public Periode getP() {
        return p;
    }
    
    public Collaborateur getCollaborateur() {
        return collaborateur;
    }
    
    public Periode getPeriode() {
        return periode;
    }
    
    // Setters para @Autowired (opcional)
    public void setCollaborateur(Collaborateur collaborateur) {
        this.collaborateur = collaborateur;
    }
    
    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}