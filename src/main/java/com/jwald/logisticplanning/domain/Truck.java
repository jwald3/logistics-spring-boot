package com.jwald.logisticplanning.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.util.List;

@Entity
public class Truck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false, unique = true)
    private String license;
    @Column(nullable=false)
    private Long capacity;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy ="truck", fetch = FetchType.LAZY)
    private List<Trip> trips;


    public Truck() {
    }

    public Truck(String license, Long capacity) {
        this.license = license;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "id=" + id +
                ", license='" + license + '\'' +
                ", capacity=" + capacity +
                ", trips=" + trips +
                '}';
    }
}
