/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.linjekoll.persistency.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author jesper
 */
@Embeddable
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "line_id");
    private Line line;
    @Column(name = "stop_id")
    private Stop stop;
    @Columns(name = "position")
    private Integer position;
    
    

    @Override
    public String toString() {
        return "se.linjekoll.persistency.entities.Order";
    }
    
}
