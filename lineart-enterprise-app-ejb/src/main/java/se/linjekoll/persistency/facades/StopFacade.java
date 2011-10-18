/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.linjekoll.persistency.facades;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import se.linjekoll.persistency.entities.Stop;
import se.linjekoll.persistency.utilities.JSONStop;

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
    
    public List<JSONStop> getStops(Integer line_id) {
        String queryString = 
                "SELECT "
                + "new se.linjekoll.persistency.utilities.JSONStop("
                + "(p.stop.id, p.stop.name "
                + "FROM Position p JOIN";
        TypedQuery<JSONStop> query = em.createQuery(queryString, JSONStop.class);
        query.setParameter("line_id", line_id);
        return query.getResultList();
    }
}
