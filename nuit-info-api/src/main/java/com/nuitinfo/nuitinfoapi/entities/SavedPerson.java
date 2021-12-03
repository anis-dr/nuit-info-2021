package com.nuitinfo.nuitinfoapi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class SavedPerson extends Person {
    @Column(name = "saved_at")
    private LocalDateTime savedAt;

    public LocalDateTime getSavedAt() {
        return savedAt;
    }

    public void setSavedAt(LocalDateTime savedAt) {
        this.savedAt = savedAt;
    }
}