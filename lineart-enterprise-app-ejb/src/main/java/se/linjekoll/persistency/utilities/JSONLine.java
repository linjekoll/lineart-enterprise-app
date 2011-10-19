/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.linjekoll.persistency.utilities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jesper
 */
@XmlRootElement
public class JSONLine {
    public String name;
    public Integer id;
    @XmlElement(name="foreground-color")
    public String foregroundColor;
    @XmlElement(name="background-color")
    public String backgroundColor;
    public Integer[] endstations;

    public JSONLine(String name, Integer id, String foregroundColor, String backgroundColor, Integer[] endstations) {
        this.name = name;
        this.id = id;
        this.foregroundColor = foregroundColor;
        this.backgroundColor = backgroundColor;
        this.endstations = endstations;
    }
    
    public JSONLine () {
        
    }
}
