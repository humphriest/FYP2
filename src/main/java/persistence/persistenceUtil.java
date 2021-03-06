package persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;


public class persistenceUtil implements Serializable {

    private static final long serialVersionUID = 1L;


    private static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("fyp2");


    public static void persist(Object entity) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    public static void remove(Object entity) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Object mergedEntity = em.merge(entity);
        em.remove(mergedEntity);
        em.getTransaction().commit();
        em.close();
    }

    public static Object merge(Object entity) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        entity = em.merge(entity);
        em.getTransaction().commit();
        em.close();
        return entity;
    }

    public static EntityManager createEM() {
        return emf.createEntityManager();
    }

}

