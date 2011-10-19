/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.linjekoll.authentication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import se.linjekoll.persistency.entities.User;

/**
 *
 * @author Schto
 */
public class userFinder {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("linjekoll_pu");
    @PersistenceContext(unitName = "linjekoll_pu")
    private EntityManager em = emf.createEntityManager();

    public userFinder() {

    }

    public User findUser(String email){
        return em.createQuery("SELECT p FROM User p WHERE p.email = :email", User.class).setParameter("email", email).getSingleResult();
    }
    
}
