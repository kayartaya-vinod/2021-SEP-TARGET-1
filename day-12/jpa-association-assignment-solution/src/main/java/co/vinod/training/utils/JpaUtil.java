package co.vinod.training.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class JpaUtil {

    private JpaUtil(){
    }

    // a single copy of EntityManagerFactory
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("TRAINING");

    // each time this method is called, a new EntityManager instance (represents a DB Connection) is returned
    public static EntityManager createEntityManager(){
        return emf.createEntityManager();
    }
}
