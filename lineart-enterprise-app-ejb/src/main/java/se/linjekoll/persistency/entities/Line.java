/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.linjekoll.persistency.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import se.linjekoll.persistency.entities.superclasses.TimeStampedEntity;


/**
 *
 * @author jesper
 */
@Entity
@Table(name = "lk_lines")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Line.findAll", query = "SELECT l FROM Line l"),
    @NamedQuery(name = "Line.findById", query = "SELECT l FROM Line l WHERE l.id = :id"),
    @NamedQuery(name = "Line.findByLid", query = "SELECT l FROM Line l WHERE l.lid = :lid"),
    @NamedQuery(name = "Line.findByProvider", query = "SELECT l FROM Line l WHERE l.provider = :provider"),
    @NamedQuery(name = "Line.findByCreatedAt", query = "SELECT l FROM Line l WHERE l.createdAt = :createdAt"),
    @NamedQuery(name = "Line.findByUpdatedAt", query = "SELECT l FROM Line l WHERE l.updatedAt = :updatedAt")})
public class Line extends TimeStampedEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 255)
    @Column(name = "lid", length = 255)
    private String lid;
    @Column(name = "name")
    private String name;
    @Column(name = "foreground-color")
    private String foregroundColor;
    @Column(name="background-color")
    private String backgroundColor;
    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;
    @ManyToMany(mappedBy="lines")
    private List<Stop> stops;
    @ManyToOne
    @JoinColumn(name = "vehicle_type_id")
    private VehicleType vehicleType;
    
    public Line() {
    }

    public Line(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLid() {
        return lid;
    }

    /**
     * @return the foregroundColor
     */
    public String getForegroundColor() {
        return foregroundColor;
    }

    /**
     * @param foregroundColor the foregroundColor to set
     */
    public void setForegroundColor(String foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    /**
     * @return the backgroundColor
     */
    public String getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * @param backgroundColor the backgroundColor to set
     */
    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the stops
     */
    public List<Stop> getStops() {
        return stops;
    }

    /**
     * @param stops the stops to set
     */
    public void setStops(List<Stop> stops) {
        this.stops = stops;
    }

    /**
     * @return the vehicleType
     */
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    /**
     * @param vehicleType the vehicleType to set
     */
    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setLid(String lid) {
        this.lid = lid;
    }

    /**
     * @return the provider
     */
    public Provider getProvider() {
        return provider;
    }

    /**
     * @param provider the provider to set
     */
    public void setProvider(Provider provider) {
        this.provider = provider;
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
        if (!(object instanceof Line)) {
            return false;
        }
        Line other = (Line) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.chl.jesjos.databasetest.Entities.Line[ id=" + id + " ]";
    }
    
}
