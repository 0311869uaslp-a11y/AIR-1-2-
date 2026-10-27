package tp4.univ.paris13.test;

import javax.persistence.*;
import java.util.List;
import tp4.univ.paris13.model.Personne;
import tp4.univ.paris13.jpa.JPAUtil;

public class TestJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        List<Personne> personnesParis = em.createQuery(
                "SELECT p FROM Personne p WHERE p.adresse.ville = :ville", Personne.class)
                .setParameter("ville", "Paris")
                .getResultList();
        System.out.println("Personnes à Paris: " + personnesParis.size());
        for (Personne p : personnesParis) {
            System.out.println(p.getNom() + " " + p.getPrenom());
        }

        tx.commit();
        em.close();
        JPAUtil.close();
    }
}
