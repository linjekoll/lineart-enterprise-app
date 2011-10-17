/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.linjekoll.persistency.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import se.linjekoll.persistency.entities.Provider;

/**
 *
 * @author jesper
 */
@Stateless
public class ProviderFacade extends AbstractFacade<Provider> {
    @PersistenceContext(unitName = "linjekoll_pu")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ProviderFacade() {
        super(Provider.class);
    }
    
}
