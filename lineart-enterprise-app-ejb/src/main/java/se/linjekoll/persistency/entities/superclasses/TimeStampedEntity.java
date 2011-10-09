/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.linjekoll.persistency.entities.superclasses;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jesper
 */
@MappedSuperclass
public class TimeStampedEntity {
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    
    public TimeStampedEntity () {
    }
    
    /**
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return the updatedAt
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt the updatedAt to set
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    @PrePersist
    public void updateTimes() {
        if (createdAt == null) {
            this.createdAt = new Date();
        }
        this.updatedAt = new Date();
    }
    
    
}
