package se.linjekoll.beans.backing;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import se.linjekoll.authentication.Authenticator;
import se.linjekoll.persistency.entities.User;
import se.linjekoll.persistency.facades.UserFacade;

/**
 *
 * @author Schto
 */
@ManagedBean(name = "authBackingBean")
@RequestScoped
public class AuthBackingBean {
    private String email;
    private String password;
    private String passwordConfirmation;

    /** Creates a new instance of AuthBackingBean */
    public AuthBackingBean() {
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the passwordConfirmation
     */
    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    /**
     * @param passwordConfirmation the passwordConfirmation to set
     */
    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }
    
    
}
