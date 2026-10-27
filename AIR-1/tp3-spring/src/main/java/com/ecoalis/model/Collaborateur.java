package com.ecoalis.model;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;


@Component  // ¡ESTA ES LA CLAVE! Spring detectará esta clase
public class Collaborateur {
    
    @Value("Dupont")  // Inyección de valores
    private String nom;
    
    @Value("Jean")
    private String prenom;
    
    @Value("IT")
    private String departement;
    
    // Constructores
    public Collaborateur() {}
    
    public Collaborateur(String nom, String prenom, String departement) {
        this.nom = nom;
        this.prenom = prenom;
        this.departement = departement;
    }
    
    // Getters y Setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    
    public String getDepartement() { return departement; }
    public void setDepartement(String departement) { this.departement = departement; }
    
    @Override
    public String toString() {
        return "Collaborateur [nom=" + nom + ", prenom=" + prenom + ", departement=" + departement + "]";
    }
}