/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.linjekoll.persistency.facades;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import se.linjekoll.persistency.entities.Role;

/**
 *
 * @author jesper
 */
@Stateless
public class RoleFacade extends AbstractFacade<Role> {
    @PersistenceContext(unitName = "postgres_pu")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public RoleFacade() {
        super(Role.class);
    }
    
    public String allJSON() {
        ObjectMapper mapper = new ObjectMapper();
        List<Role> roles = this.findAll();
        String json = "";
        try {
            json = mapper.writeValueAsString(roles);
        } catch (IOException ex) {
            Logger.getLogger(RoleFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }
    
}
