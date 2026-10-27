package com.ecoalis.dao;

import com.ecoalis.model.Collaborateur;

public class CollaborateurDaoSupportTest extends SpringDaoTest {

   private CollaborateurDaoSupport collaborateurDaoSupport;

   protected String[] getTestFixtures() {
      return new String[] { "Collaborateur.db.xml" };
   }

   public void testFind() {
      Collaborateur collaborateur = collaborateurDaoSupport.find(1);

      System.out.println("collaborateur=" + collaborateur);
      assertEquals("John", collaborateur.getPrenom());
      assertEquals("Doe", collaborateur.getNom());
   }

   public CollaborateurDaoSupport getCollaborateurDaoSupport() {
      return collaborateurDaoSupport;
   }

   public void setCollaborateurDao(CollaborateurDaoSupport collaborateurDaoSupport) {
      this.collaborateurDaoSupport = collaborateurDaoSupport;
   }
}