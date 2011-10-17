/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.linjekoll.persistency.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import se.linjekoll.persistency.entities.Stop;

/**
 *
 * @author jesper
 */
@Stateless
public class StopFacade extends AbstractFacade<Stop> {
    @PersistenceContext(unitName = "linjekoll_pu")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public StopFacade() {
        super(Stop.class);
    }
    
}
