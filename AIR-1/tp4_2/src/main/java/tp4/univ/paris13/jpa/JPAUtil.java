package tp4.univ.paris13.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("tp4-jpa");

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    public static void close() {
        emf.close();
    }
}
