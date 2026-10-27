package com.ecoalis.dao;

import com.ecoalis.model.Collaborateur;

public class CollaborateurDaoTest extends SpringDaoTest {

   private CollaborateurDao collaborateurDao;

   protected String[] getTestFixtures() {
      return new String[] { "Collaborateur.db.xml" };
   }

   public void testFind() {
      Collaborateur collaborateur = collaborateurDao.find(1);

      System.out.println("collaborateur=" + collaborateur);
      assertEquals("John", collaborateur.getPrenom());
      assertEquals("Doe", collaborateur.getNom());
   }

   public CollaborateurDao getCollaborateurDao() {
      return collaborateurDao;
   }

   public void setCollaborateurDao(CollaborateurDao collaborateurDao) {
      this.collaborateurDao = collaborateurDao;
   }
}