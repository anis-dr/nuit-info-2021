package com.nuitinfo.nuitinfoapi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class SavedPerson extends Person {
    @Temporal(TemporalType.DATE)
    @Column(name = "saved_at")
    private Date savedAt;

    public Date getSavedAt() {
        return savedAt;
    }

    public void setSavedAt(Date savedAt) {
        this.savedAt = savedAt;
    }
}