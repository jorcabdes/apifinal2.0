package org.example.apifinal.modelo;

import jakarta.persistence.*;

import java.util.Date;

@MappedSuperclass
public abstract class TimeStampedPersistableObject {

    @Column(nullable = false, name = "insert_ts", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertTimeStamp;

    @Column(nullable = false, name = "update_ts")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTimeStamp;

    @PrePersist
    public void onInsert() {
        this.insertTimeStamp = new Date();
        this.updateTimeStamp = this.insertTimeStamp;
    }
    @PreUpdate
    public void onUpdate() {
        this.updateTimeStamp = new Date();
    }
}
