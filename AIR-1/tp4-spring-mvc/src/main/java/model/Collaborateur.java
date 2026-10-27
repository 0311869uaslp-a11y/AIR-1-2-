package com.ecoalis.model;

public class Collaborateur {
    private Long id;
    private String nom;
    private String prenom;
    private String departement;
    
    // Constructores
    public Collaborateur() {}
    
    public Collaborateur(Long id, String nom, String prenom, String departement) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.departement = departement;
    }
    
    // ¡¡¡GETTERS Y SETTERS COMPLETOS!!!
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public String getDepartement() {
        return departement;
    }
    
    public void setDepartement(String departement) {
        this.departement = departement;
    }
    
    @Override
    public String toString() {
        return nom + " " + prenom + " (" + departement + ")";
    }
}