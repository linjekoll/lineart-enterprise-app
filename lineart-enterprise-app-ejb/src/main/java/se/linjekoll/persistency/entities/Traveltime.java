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
    @NamedQuery(name = "Traveltime.findByOrigin", query = "SELECT t FROM Traveltime t WHERE t.origin = :origin"),
    @NamedQuery(name = "Traveltime.findByDestination", query = "SELECT t FROM Traveltime t WHERE t.destination = :destination"),
    @NamedQuery(name = "Traveltime.findByLine", query = "SELECT t FROM Traveltime t WHERE t.line = :line"),
    @NamedQuery(name = "Traveltime.findByTime", query = "SELECT t FROM Traveltime t WHERE t.time = :time"),
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
    @JoinColumn(name = "origin_id")
    private Stop origin;
    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Stop destination;
    @ManyToOne
    @JoinColumn(name = "line_id")
    private Line line;
    @Column(name = "time")
    private Integer time;

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
     * @return the origin
     */
    public Stop getOrigin() {
        return origin;
    }

    /**
     * @param origin the origin to set
     */
    public void setOrigin(Stop origin) {
        this.origin = origin;
    }

    /**
     * @return the destination
     */
    public Stop getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(Stop destination) {
        this.destination = destination;
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



    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
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
                " origin: " + origin.getName() + 
                " destination: " + destination.getName() +
                " time: " + time;
    }
    
}
