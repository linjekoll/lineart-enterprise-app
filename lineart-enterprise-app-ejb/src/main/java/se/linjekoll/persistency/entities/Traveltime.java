/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.linjekoll.persistency.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import se.linjekoll.persistency.entities.superclasses.TimeStampedEntity;

/**
 *
 * @author jesper
 */
@Entity
@Table(name = "traveltimes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Traveltime.findAll", query = "SELECT t FROM Traveltime t"),
    @NamedQuery(name = "Traveltime.findById", query = "SELECT t FROM Traveltime t WHERE t.id = :id"),
    @NamedQuery(name = "Traveltime.findByprevious", query = "SELECT t FROM Traveltime t WHERE t.previous = :previous"),
    @NamedQuery(name = "Traveltime.findBynext", query = "SELECT t FROM Traveltime t WHERE t.next = :next"),
    @NamedQuery(name = "Traveltime.findByLine", query = "SELECT t FROM Traveltime t WHERE t.line = :line"),
    @NamedQuery(name = "Traveltime.findByDuration", query = "SELECT t FROM Traveltime t WHERE t.duration = :duration"),
    @NamedQuery(name = "Traveltime.findByCreatedAt", query = "SELECT t FROM Traveltime t WHERE t.createdAt = :createdAt"),
    @NamedQuery(name = "Traveltime.findByUpdatedAt", query = "SELECT t FROM Traveltime t WHERE t.updatedAt = :updatedAt")})
public class Traveltime extends TimeStampedEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "previous_id")
    private Stop previous;
    @ManyToOne
    @JoinColumn(name = "next_id")
    private Stop next;
    @ManyToOne
    @JoinColumn(name = "line_id")
    private Line line;
    @Column(name = "duration")
    private Integer duration;
    @Column(name = "position")
    private Integer position;

    public Traveltime() {
    }

    public Traveltime(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the previous
     */
    public Stop getprevious() {
        return previous;
    }

    /**
     * @param previous the previous to set
     */
    public void setprevious(Stop previous) {
        this.previous = previous;
    }

    /**
     * @return the next
     */
    public Stop getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(Stop next) {
        this.next = next;
    }

    /**
     * @return the line
     */
    public Line getLine() {
        return line;
    }

    /**
     * @param line the line to set
     */
    public void setLine(Line line) {
        this.line = line;
    }



    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Traveltime)) {
            return false;
        }
        Traveltime other = (Traveltime) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Traveltime id: " + id + 
                " previous: " + previous.getName() + 
                " next: " + next.getName() +
                " duration: " + duration;
    }

    
}
