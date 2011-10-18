/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.linjekoll.persistency.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jesper
 */
@Entity
@Table(name ="positions")
public class Position implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="line_id")
    private Line line;
    @ManyToOne
    @JoinColumn(name="stop_id")
    private Stop stop;
    @Column(name="position")
    private Integer position;
        
    @Override
    public String toString() {
        return "se.linjekoll.persistency.entities.Order";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.line != other.line && (this.line == null || !this.line.equals(other.line))) {
            return false;
        }
        if (this.stop != other.stop && (this.stop == null || !this.stop.equals(other.stop))) {
            return false;
        }
        if (this.position != other.position && (this.position == null || !this.position.equals(other.position))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 47 * hash + (this.line != null ? this.line.hashCode() : 0);
        hash = 47 * hash + (this.stop != null ? this.stop.hashCode() : 0);
        hash = 47 * hash + (this.position != null ? this.position.hashCode() : 0);
        return hash;
    }
    
    

}
