/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.linjekoll;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

/**
 *
 * @author Schtohan
 */
@ManagedBean(name = "authenticationBean")
@RequestScoped
public class authenticationBean {

    private String userName;
    private String password;
    private String password2;
    private List<Person> users = new ArrayList<Person>();
    private static EntityManagerFactory emf;
    
    @PersistenceContext 
    private EntityManager em;
    
    @Resource 
    private UserTransaction utx;
        
    /** Creates a new instance of nameBean */
    public authenticationBean() {
        emf = Persistence.createEntityManagerFactory("users_pu");
    }

    public List<Person> getUsers() {
        return users;
    }

    public void setUsers(List<Person> users) {
        this.users = users;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
    
    
    
    public String doAddPerson(){
        
        Person p = new Person(userName, password);
        users.add(p);  
        return "onAddUser";
        
    }
    
    public String login() {   
        FacesContext context = FacesContext.getCurrentInstance();
        Person person;
        try {
            person = (Person) em.createQuery("SELECT p FROM Person p WHERE p.userName = :username", Person.class).setParameter("username", userName).getSingleResult();
        } catch (NoResultException nre) {
            person = null;
        }
        if (person != null) {
            if (!person.getPassword().equals(password)) {
                FacesMessage message = new FacesMessage("felaktigt lösenord");
                context.addMessage(null, message);
                return null;
            }
            
            context.getExternalContext().getSessionMap().put("person", person);
            return "onLogin";
        } else {           
            context.addMessage(null, new FacesMessage("användare ej registrerad"));
            return null;
        }
    }
    
    public String createPerson(){
        
        FacesContext context = FacesContext.getCurrentInstance();
        Person person;
        try {
            person = (Person) em.createQuery("SELECT p FROM Person p WHERE p.userName = :username", Person.class).setParameter("username", userName).getSingleResult();
        } catch (NoResultException nre) {
            person = null;
        }
            if (person == null) {
            if (!password.equals(password2)) {
                context.addMessage(null, new FacesMessage("Lösenorden stämmer ej överens! Försök igen."));
                return null;
            }
            person = new Person();
            person.setUserName(userName);
            person.setPassword(password);
            
            try {
                utx.begin();
                em.persist(person);
                utx.commit();
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
