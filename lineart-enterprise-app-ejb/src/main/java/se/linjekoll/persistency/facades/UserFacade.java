/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.linjekoll.persistency.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import se.linjekoll.persistency.entities.User;

/**
 *
 * @author jesper
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {
    @PersistenceContext(unitName = "linjekoll_pu")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }

    public User findByEmail(String email) {
        TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
        query.setParameter("email", email);
        User user = null;
        try {
            user = query.getSingleResult();
        } catch(NoResultException e) {
            System.err.println("Could not find user");
            return null;
        }
        return user;
    }
    
}
