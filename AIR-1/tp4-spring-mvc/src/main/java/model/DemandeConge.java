package com.ecoalis.model;

import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.*;
import java.util.Date;

public class DemandeConge {
    private Long id;
    
   // @NotNull(message = "Le collaborateur est obligatoire")
    private Collaborateur collaborateur;
    
    //@NotNull(message = "La date de début est obligatoire")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDebut;
    
    @Min(value = 1, message = "Le nombre de jours doit être au moins 1")
    @Max(value = 30, message = "Le nombre de jours ne peut dépasser 30")
    private int nbJours;
    
   // @NotNull(message = "Le type de congé est obligatoire")
    private TypeDdc typeDdc;
    
    private String commentaire;
    
    private String statut = "EN_ATTENTE";
    
    // Constructores
    public DemandeConge() {}
    
    public DemandeConge(Long id, Collaborateur collaborateur, Date dateDebut, int nbJours, TypeDdc typeDdc) {
        this.id = id;
        this.collaborateur = collaborateur;
        this.dateDebut = dateDebut;
        this.nbJours = nbJours;
        this.typeDdc = typeDdc;
    }
    
    // Getters y Setters (todos)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Collaborateur getCollaborateur() { return collaborateur; }
    public void setCollaborateur(Collaborateur collaborateur) { this.collaborateur = collaborateur; }
    
    public Date getDateDebut() { return dateDebut; }
    public void setDateDebut(Date dateDebut) { this.dateDebut = dateDebut; }
    
    public int getNbJours() { return nbJours; }
    public void setNbJours(int nbJours) { this.nbJours = nbJours; }
    
    public TypeDdc getTypeDdc() { return typeDdc; }
    public void setTypeDdc(TypeDdc typeDdc) { this.typeDdc = typeDdc; }
    
    public String getCommentaire() { return commentaire; }
    public void setCommentaire(String commentaire) { this.commentaire = commentaire; }
    
    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }
    
    // Método para formatear fecha (útil en JSP)
    public String getDateDebutFormatted() {
        if (dateDebut == null) return "";
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(dateDebut);
    }
    
    @Override
    public String toString() {
        return "DemandeConge #" + id + " - " + collaborateur + " - " + dateDebut + " (" + nbJours + " jours)";
    }
}