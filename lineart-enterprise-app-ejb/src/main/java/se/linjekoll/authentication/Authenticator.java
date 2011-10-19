/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.linjekoll.authentication;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.jasypt.digest.StandardStringDigester;
import org.jasypt.salt.RandomSaltGenerator;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;
import se.linjekoll.persistency.entities.User;
import se.linjekoll.persistency.facades.UserFacade;

/**
 *
 * @author Schtohan
 */
@Stateless
public class Authenticator {

    @EJB
    private UserFacade userFacade;
    private StrongPasswordEncryptor encryptor;
    private StandardStringDigester digester;
    private RandomSaltGenerator salt;

    public Authenticator() {
        this.encryptor = new StrongPasswordEncryptor();
    }
    
    public User authenticate(String email, String password) {
        User user = userFacade.findByEmail(email);
        if (user == null) {
            return null;
        } else {
            if (encryptor.checkPassword(password, user.getPasswordHash())) {
                return user;
            } else {
                return null;
            }
        }
    }
    
    public User register(String email, String password) {
        User existing = userFacade.findByEmail(email);
        if (existing != null) {
            return null;
        } else {
            User user = new User();
            String encryptedPassword = encryptor.encryptPassword(password);
            user.setPasswordHash(encryptedPassword);
            user.setEmail(email);
            System.err.println(user);   
            try {
                userFacade.create(user);
            } catch (ConstraintViolationException e) {
                System.err.println("Constraint violation");
                Set<ConstraintViolation<?>> vs = e.getConstraintViolations();
                for(ConstraintViolation<?> v : vs) {
                    System.err.println(e.getConstraintViolations());
                }
            } catch (Exception e) {
                System.err.println("No constraint, but: " + e.getMessage());
            }
            return user;
        }
        
    }
}
