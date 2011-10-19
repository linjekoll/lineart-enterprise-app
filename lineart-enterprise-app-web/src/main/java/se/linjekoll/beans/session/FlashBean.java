/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.linjekoll.beans.session;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jesper
 */
@ManagedBean(name = "flashBean")
@SessionScoped
public class FlashBean implements Serializable {

    String message;

    public FlashBean() {
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        if (this.message != null) {
            String _message = this.message;
            this.message = null;
            return _message;
        } else {
            throw new NullPointerException("No message in flash object!");
        }
    }
    
    public boolean isMessagePresent() {
        return this.message != null;
    }
    
    @Override
    public String toString() {
        return "Flash: " + this.message;
    }
}
