/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.linjekoll.persistency.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import se.linjekoll.persistency.entities.Line;
import se.linjekoll.persistency.utilities.JSONLine;

/**
 *
 * @author jesper
 */
@Stateless
public class LineFacade extends AbstractFacade<Line> {
    @PersistenceContext(unitName = "linjekoll_pu")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public LineFacade() {
        super(Line.class);
    }
    
    public JSONLine getJSONLineForId(Integer id) {
        String lineQueryString = "SELECT "
                + "new se.linjekoll.persistency.utilities.JSONLine("
                + "l.name, l.id, l.foregroundColor, l.backgroundColor, null) "
                + "FROM Line l, Position p "
                + "WHERE l.id = :line_id ";
        TypedQuery<JSONLine> query = em.createQuery(lineQueryString, JSONLine.class);
        String endStationsQueryString = "SELECT "
                + "*"
                + "FROM Position p "
                + "WHERE p.position = min(p.position) "
                + "OR p.position = max(p.position)";
        JSONLine line = query.getSingleResult();
        return null;
    }
    // String name, Integer id, String foregroundColor, String backgroundColor, Integer[] endstations
}
