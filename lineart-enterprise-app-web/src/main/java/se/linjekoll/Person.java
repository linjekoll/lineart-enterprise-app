/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.linjekoll;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Schtohan
 */
@Entity
public class Person implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "USERNAME", nullable = false)
    private String userName;
    
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    
    public Person() {
    }
    
    public Person(String userName, String password) {
        
        this.userName = userName;
        this.password = password;
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    
    
    
    
    
}
