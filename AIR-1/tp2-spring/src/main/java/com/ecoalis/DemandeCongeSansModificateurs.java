package com.ecoalis;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class DemandeCongeSansModificateurs {
    private Collaborateur collaborateur;
    private Periode periode;

    // Constructor para autowiring "constructor"
    public DemandeCongeSansModificateurs(Collaborateur collaborateur, Periode periode) {
        this.collaborateur = collaborateur;
        this.periode = periode;
    }
    
    public Collaborateur getCollaborateur() {
        return collaborateur;
    }
    
    public Periode getPeriode() {
        return periode;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}