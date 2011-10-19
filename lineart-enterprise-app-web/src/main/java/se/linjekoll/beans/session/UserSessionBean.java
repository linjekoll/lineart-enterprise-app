/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.linjekoll.beans.session;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import se.linjekoll.persistency.entities.User;

/**
 *
 * @author jesper
 */
@ManagedBean
@RequestScoped
public class UserSessionBean {
    private User user;
    /** Creates a new instance of UserSessionBean */
    public UserSessionBean() {
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
    
    
}
