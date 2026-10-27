package com.ecoalis.model;

import javax.validation.constraints.Min;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class DemandeConge {

   private Collaborateur collaborateur;
   private Periode periode;
   private int numero;
   private TypeDdc type;

   public DemandeConge() {
      this.periode = new Periode();
      this.collaborateur = new Collaborateur();
   }

   public Collaborateur getCollaborateur() {
      return collaborateur;
   }

   public void setCollaborateur(Collaborateur collaborateur) {
      this.collaborateur = collaborateur;
   }

   public Periode getPeriode() {
      return periode;
   }

   public void setPeriode(Periode periode) {
      this.periode = periode;
   }

   @Min(value = 1, message = "Le numéro de demande doit être plus grand que 1")
   public int getNumero() {
      return numero;
   }

   public void setNumero(int numero) {
      this.numero = numero;
   }

   public TypeDdc getType() {
      return type;
   }

   public void setType(TypeDdc type) {
      this.type = type;
   }

   @Override
   public String toString() {
      return ToStringBuilder.reflectionToString(this);
   }
}
