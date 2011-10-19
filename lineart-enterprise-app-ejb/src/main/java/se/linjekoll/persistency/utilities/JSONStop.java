/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.linjekoll.persistency.utilities;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A utility class for collecting information about stops from differente tables
 * and serializing them to JSON.
 * 
 * @author jesper
 */

@XmlRootElement
public class JSONStop implements Serializable{
    public String name;
    public Integer id;
    public Integer time;
    public String sid;
    public Integer position;

    public JSONStop(String name, Integer id, Integer time, String sid, Integer position) {
        this.name = name;
        this.id = id;
        this.time = time;
        this.sid = sid;
        this.position = position;
    }
    
    public JSONStop() {
        
    }
    
    
    
}

