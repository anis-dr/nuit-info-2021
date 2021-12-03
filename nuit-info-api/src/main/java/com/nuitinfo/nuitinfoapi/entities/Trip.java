package com.nuitinfo.nuitinfoapi.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Table(name = "trip")
@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "trips_rescuers",
            joinColumns = {
                    @JoinColumn(name = "trip_id", referencedColumnName = "id",
                            nullable = true, updatable = true)},
            inverseJoinColumns = {
                    @JoinColumn(name = "rescuer_id", referencedColumnName = "id",
                            nullable = true, updatable = true)})
    private List<RescuerPerson> rescuers = new ArrayList<>();

    @Column(name = "departure_time")
    private LocalDateTime departureTime;

    public Trip(Long id, List<RescuerPerson> rescuers, LocalDateTime departureTime) {
        this.id = id;
        this.rescuers = rescuers;
        this.departureTime = departureTime;
    }

    public Trip() {
    }

    public List<RescuerPerson> getRescuers() {
        return rescuers;
    }

    public void setRescuers(List<RescuerPerson> rescuers) {
        this.rescuers = rescuers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }
}