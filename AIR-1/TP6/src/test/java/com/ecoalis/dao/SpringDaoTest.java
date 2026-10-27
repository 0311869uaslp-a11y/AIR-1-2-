package com.ecoalis.dao;

import java.io.InputStream;

import javax.persistence.EntityManagerFactory;

import org.hibernate.ejb.HibernateEntityManager;
import org.springframework.test.AbstractTransactionalSpringContextTests;

import com.ecoalis.model.Collaborateur;

public abstract class SpringDaoTest extends AbstractTransactionalSpringContextTests {

   private EntityManagerFactory entityManagerFactory;

   protected String[] getConfigLocations() {
      return new String[] { "applicationContext.xml", "applicationContext-test.xml" };
   }

   /**
    * Array of DbUnit XML data set files to loaded, in order, into the test
    * database. Files will be located on the classpath.
    * 
    * @return
    */
   protected abstract String[] getTestFixtures();

   protected void onSetUpBeforeTransaction() throws Exception {
      HibernateEntityManager em = (HibernateEntityManager) getEntityManagerFactory().createEntityManager();

      for (String fixture : getTestFixtures()) {
         InputStream testData = Collaborateur.class.getResourceAsStream("/" + fixture);

         DbUnitDataLoader loader = new DbUnitDataLoader(testData, em.getSession().connection());

         loader.populateTestData();
      }
   }

   public EntityManagerFactory getEntityManagerFactory() {
      return entityManagerFactory;
   }

   public void setEntityManagerFactory(EntityManagerFactory emf) {
      this.entityManagerFactory = emf;
   }
}