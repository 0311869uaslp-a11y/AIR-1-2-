package com.ecoalis;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Collaborateur {
    private String nom;
    private String prenom;

    public Collaborateur() {}

    public void setNom(String nom) { this.nom = nom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}