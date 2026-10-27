package tp4.univ.paris13.model;

import javax.persistence.*;
import java.util.List;

public class TestJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("paris13PU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            // === 1. CREAR DIRECCIONES ===
            Adresse a1 = new Adresse(10, "Rue de la Paix", "75001", "Paris", "France");
            Adresse a2 = new Adresse(20, "Avenue des Champs", "69001", "Lyon", "France");
            em.persist(a1);
            em.persist(a2);
            em.flush(); // OBLIGATORIO: fuerza INSERT y genera ID

            // === 2. CREAR PERSONAS ===
            Personne p1 = new Personne("Dubois", "Marie", "0123456789", "marie@email.com", a2);
            Personne p2 = new Personne("Leroy", "Paul", "0987654321", "paul@email.com", a1);
            em.persist(p1);
            em.persist(p2);

            tx.commit();

            // === 3. CONSULTA JPQL ===
            Query q = em.createQuery("SELECT p FROM Personne p JOIN FETCH p.adresse");
            List<Personne> list = q.getResultList();
            for (Personne p : list) {
                System.out.println(p.getNom() + " " + p.getPrenom() + " → " + p.getAdresse().getVille());
            }

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}