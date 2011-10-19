package se.linjekoll.web.beans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import se.linjekoll.authentication.Authentication;
import se.linjekoll.persistency.entities.User;
import se.linjekoll.persistency.facades.UserFacade;

/**
 *
 * @author Schto
 */
@ManagedBean(name = "authenticationBean")
@RequestScoped
public class authenticationBean {
    
    @EJB
    private Authentication a = new Authentication();

    /** Creates a new instance of authenticationBean */
    public authenticationBean() {
    }
    
    public void setEmail(String email){
        a.setEmail(email);
    }
    
    public String getEmail(){
        return a.getEmail();
    }
    
    public void setPassword(String password){
        a.setPassword(password);
    }
    
    public String getPassword(){
        return a.getPassword();
    }
    
    public void setPassword2(String password2){
        a.setPassword2(password2);
    }
    
    public String getPassword2(){
        return a.getPassword2();
    }
    
    public String createUser(){
        return a.createUser();
    }
}
