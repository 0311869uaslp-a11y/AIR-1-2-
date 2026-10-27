package tp4.univ.paris13.model;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import tp4.univ.paris13.model.Personne;
import tp4.univ.paris13.model.Adresse;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration().configure();
            configuration.addPackage("tp4.univ.paris13.model")
                         .addAnnotatedClass(Personne.class)
                         .addAnnotatedClass(Adresse.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                         .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }
}