/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.linjekoll.beans.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.validation.ConstraintViolationException;
import se.linjekoll.authentication.Authenticator;
import se.linjekoll.beans.backing.AuthBackingBean;
import se.linjekoll.beans.session.FlashBean;
import se.linjekoll.beans.session.UserSessionBean;
import se.linjekoll.persistency.entities.User;

/**
 *
 * @author jesper
 */
@ManagedBean(name="authControllerBean")
@RequestScoped
public class AuthControllerBean {
    @ManagedProperty(value="#{authBackingBean}")
    private AuthBackingBean page;
    @ManagedProperty(value="#{userSessionBean}")
    private UserSessionBean session;
    @ManagedProperty(value="#{flashBean}")
    private FlashBean flashBean;
    @EJB
    private Authenticator auth;
    /** Creates a new instance of AuthControllerBean */
    public AuthControllerBean() {
    }
    
    public String authenticate() {
        String email = page.getEmail();
        String password = page.getPassword();
        User user = auth.authenticate(email, password);
        if (user == null) {
            getFlashBean().setMessage("Det gick inte att logga in.");
            return "loginFailed";
        } else {
            getFlashBean().setMessage("Du är inloggad!");
            getSession().setUser(user);
            return "loginSucceeded";
        }
    }
    
    public String register() {
        String email = page.getEmail();
        String password = page.getPassword();
        User user = null;
        try {
            user = auth.register(email, password);
        } catch (ConstraintViolationException e) {
            System.err.println(e.getConstraintViolations());
        }
        if (user == null) {
            getFlashBean().setMessage("Det gick inte att registrera dig, antagligen finns adressen redan i databasen");
            return "registrationFailed";
        } else {
            getFlashBean().setMessage("Du är nu registrerad, välkommen!");
            getSession().setUser(user);
            return "registrationSucceeded";
        }
    }

    /**
     * @return the page
     */
    public AuthBackingBean getPage() {
        return page;
    }

    /**
     * @param page the page to set
     */
    public void setPage(AuthBackingBean page) {
        this.page = page;
    }

    /**
     * @return the auth
     */
    public Authenticator getAuth() {
        return auth;
    }

    /**
     * @param auth the auth to set
     */
    public void setAuth(Authenticator auth) {
        this.auth = auth;
    }

    /**
     * @return the session
     */
    public UserSessionBean getSession() {
        return session;
    }

    /**
     * @param session the session to set
     */
    public void setSession(UserSessionBean session) {
        this.session = session;
    }

    /**
     * @return the flashBean
     */
    public FlashBean getFlashBean() {
        return flashBean;
    }

    /**
     * @param flashBean the flashBean to set
     */
    public void setFlashBean(FlashBean flashBean) {
        this.flashBean = flashBean;
    }
    
    
}
