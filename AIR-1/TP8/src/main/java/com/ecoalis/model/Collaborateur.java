package com.ecoalis.model;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Collaborateur {

   private String nom;
   private String prenom;

   public Collaborateur() {
   }

   public Collaborateur(String nom, String prenom) {
      super();
      this.nom = nom;
      this.prenom = prenom;
   }

   @NotNull(message = "hey hey hey.... le nom est null")
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

   @Override
   public String toString() {
      return ToStringBuilder.reflectionToString(this);
   }
}
