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
                + "new se.linjekoll.persistency.utilities.JSONStop(stop.name, stop.id, t.duration, stop.sid, p.position) "
                + "FROM TravelTime t, Position p "
                + "JOIN t.previous stop "
                + "WHERE t.line.id = :line_id "
                + "AND p.stop = stop AND p.line.id = :line_id "
                + "ORDER BY p.position";
        TypedQuery<JSONStop> query = em.createQuery(queryString, JSONStop.class);
        query.setParameter("line_id", line_id);
        return query.getResultList();
    }
    
    public List<Stop> searchByName(String input) {
        String queryString = 
                "SELECT "
                + "stop "
                + "FROM Stop s "
                + "WHERE lower(s.name) LIKE lower('%:query%') "
                + "LIMIT 10";
        TypedQuery<Stop> query = em.createQuery(queryString, Stop.class);
        query.setParameter("query", input);
        List<Stop> stop = query.getResultList();
        return stop;
    }
}
