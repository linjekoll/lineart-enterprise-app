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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import se.linjekoll.persistency.entities.Position;
import se.linjekoll.persistency.entities.Stop;

/**
 *
 * @author jesper
 */
@Stateless
public class PositionFacade extends AbstractFacade<Position> {
    @PersistenceContext(unitName = "linjekoll_pu")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public PositionFacade() {
        super(Position.class);
    }
    
}
