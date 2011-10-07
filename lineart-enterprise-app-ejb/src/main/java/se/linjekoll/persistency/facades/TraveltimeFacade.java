/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.linjekoll.persistency.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import se.linjekoll.persistency.entities.Traveltime;

/**
 *
 * @author jesper
 */
@Stateless
public class TraveltimeFacade extends AbstractFacade<Traveltime> {
    @PersistenceContext(unitName = "postgres_pu")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TraveltimeFacade() {
        super(Traveltime.class);
    }
    
}
