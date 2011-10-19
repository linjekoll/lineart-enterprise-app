/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.linjekoll.authentication;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;
import org.jasypt.util.password.BasicPasswordEncryptor;
import se.linjekoll.persistency.entities.User;
import se.linjekoll.persistency.facades.UserFacade;


/**
 *
 * @author Schtohan
 */
@Stateless
public class Authentication {

    private String email;
    private String password;
    private String password2;    
    private List<User> users = new ArrayList<User>();
    private UserFacade userFacade = new UserFacade();
    private BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
            
    /** Creates a new instance of nameBean */
    public Authentication() {

   }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
    
    public String login() {   
        FacesContext context = FacesContext.getCurrentInstance();
        User user;
        try {
            userFinder uf = new userFinder();
            user = uf.findUser(email);
        } catch (NoResultException nre) {
            user = null;
        }
        if (user != null) {
            if (!passwordEncryptor.checkPassword(password, user.getPasswordSalt())) {
                FacesMessage message = new FacesMessage("felaktigt lösenord");
                context.addMessage(null, message);
                return null;
            }
            
            context.getExternalContext().getSessionMap().put("user", user);
            return "onLogin";
        } else {           
            context.addMessage(null, new FacesMessage("användare ej registrerad"));
            return null;
        }
    }
    
    public String createUser(){
        
        FacesContext context = FacesContext.getCurrentInstance();
        User user;
        try {
            userFinder uf = new userFinder();
            user = uf.findUser(email); 
        } catch (NoResultException nre) {
            user = null;
        }
            if (user == null) {
            if (!password.equals(password2)) {
                context.addMessage(null, new FacesMessage("Lösenorden stämmer ej överens! Försök igen."));
                return null;
            }
            user = new User();
            user.setEmail(email);
            String encryptedPassword = passwordEncryptor.encryptPassword(password);
            user.setPasswordSalt(encryptedPassword);
            
            try {
                userFacade.create(user);
                return "onRegistration";
            } catch (Exception e) {
                context.addMessage(null, new FacesMessage("Ett fel uppstod!"));
                return null;
            }
        } else {           
            context.addMessage(null, new FacesMessage("Användarnamnet finns redan. Var vänlig välj ett nytt."));
            return null;
        }
         
        
    }
    
    public String logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "onLogout";
        
    }
    
    
    
}
