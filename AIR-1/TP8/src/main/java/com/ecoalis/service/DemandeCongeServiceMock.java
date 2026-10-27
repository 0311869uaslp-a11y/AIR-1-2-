package com.ecoalis.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ecoalis.model.DemandeConge;

@Service
public class DemandeCongeServiceMock {

   private static List<DemandeConge> demandes = new ArrayList<>();

   public void save(DemandeConge dc) {
      demandes.add(dc);
   }

   public List<DemandeConge> findAll() {
      return demandes;
   }

   public DemandeConge getDemandeConge(int ddcId) {
      for (DemandeConge dc : demandes) {
         if (dc.getNumero() == ddcId) {
            return dc;
         }
      }
      return null;
   }
}
