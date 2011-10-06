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
import javax.persistence.JoinTable;
import javax.persistence.Lob;
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

/**
 *
 * @author jesper
 */
@Entity
@Table(name = "stops")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stop.findAll", query = "SELECT s FROM Stop s"),
    @NamedQuery(name = "Stop.findById", query = "SELECT s FROM Stop s WHERE s.id = :id"),
    @NamedQuery(name = "Stop.findBySid", query = "SELECT s FROM Stop s WHERE s.sid = :sid"),
    @NamedQuery(name = "Stop.findByProvider", query = "SELECT s FROM Stop s WHERE s.provider = :provider"),
    @NamedQuery(name = "Stop.findByName", query = "SELECT s FROM Stop s WHERE s.name = :name"),
    @NamedQuery(name = "Stop.findByCreatedAt", query = "SELECT s FROM Stop s WHERE s.createdAt = :createdAt"),
    @NamedQuery(name = "Stop.findByUpdatedAt", query = "SELECT s FROM Stop s WHERE s.updatedAt = :updatedAt")})
public class Stop implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "sid")
    private String sid;
    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;
    @Lob
    @Size(max = 65535)
    @Column(name = "coordinate", length = 65535)
    private String coordinate;
    @Size(max = 255)
    @Column(name = "name", length = 255)
    private String name;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @ManyToMany
    @JoinTable(
            name="lines_stops",
            joinColumns = {@JoinColumn(name="line_id", referencedColumnName="id")},
            inverseJoinColumns = {@JoinColumn(name="stop_id", referencedColumnName="id")})
    private List<Line> lines;

    public Stop() {
    }

    public Stop(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
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
        if (!(object instanceof Stop)) {
            return false;
        }
        Stop other = (Stop) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Stop id: " + id +
                " name: " + name +
                " provider: " + provider;
    }

    /**
     * @return the sid
     */
    public String getSid() {
        return sid;
    }

    /**
     * @param sid the sid to set
     */
    public void setSid(String sid) {
        this.sid = sid;
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
    
}
