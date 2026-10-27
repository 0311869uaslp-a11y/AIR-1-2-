package tp4.univ.paris13.model;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Test {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Session session = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            // Query for Personne
            List<Personne> personnes = session.createCriteria(Personne.class).list();
            System.out.println("With CRITERIA API (Personne): personnes: " + personnes.size());

            List<Personne> personnesHQL = session.createQuery("FROM Personne").list();
            System.out.println("WITH HQL QUERY (Personne): personnesHQL: " + personnesHQL.size());

            List personnesSQL = session.createSQLQuery("select * from personne").addEntity(Personne.class).list();
            System.out.println("WITH SQL QUERY (Personne): personnesSQL: " + personnesSQL.size());

            // Query for Adresse
            List<Adresse> adresses = session.createCriteria(Adresse.class).list();
            System.out.println("With CRITERIA API (Adresse): adresses: " + adresses.size());

            List<Adresse> adressesHQL = session.createQuery("FROM Adresse").list();
            System.out.println("WITH HQL QUERY (Adresse): adressesHQL: " + adressesHQL.size());

            List adressesSQL = session.createSQLQuery("select * from adresse").addEntity(Adresse.class).list();
            System.out.println("WITH SQL QUERY (Adresse): adressesSQL: " + adressesSQL.size());

            tx.commit();
            System.out.println("Done");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }
}