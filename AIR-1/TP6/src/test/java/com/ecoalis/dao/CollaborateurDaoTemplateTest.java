package com.ecoalis.dao;

import com.ecoalis.model.Collaborateur;

public class CollaborateurDaoTemplateTest extends SpringDaoTest {

   private CollaborateurDaoTemplate collaborateurDaoTemplate;

   protected String[] getTestFixtures() {
      return new String[] { "Collaborateur.db.xml" };
   }

   public void testFind() {
      Collaborateur collaborateur = collaborateurDaoTemplate.find(1);

      System.out.println("collaborateur=" + collaborateur);
      assertEquals("John", collaborateur.getPrenom());
      assertEquals("Doe", collaborateur.getNom());
   }

   public CollaborateurDaoTemplate getCollaborateurDaoTemplate() {
      return collaborateurDaoTemplate;
   }

   public void setCollaborateurDao(CollaborateurDaoTemplate collaborateurDaoTemplate) {
      this.collaborateurDaoTemplate = collaborateurDaoTemplate;
   }
}