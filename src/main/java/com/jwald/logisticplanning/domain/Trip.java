package com.jwald.logisticplanning.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tripId;
    @Column(nullable=false, unique = true)
    private String tripIdentifier;

    @Column(nullable=false)
    private LocalDateTime startDate;
    @Column(nullable=false)
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name="truck_id", nullable = true)
    @JsonIgnoreProperties("trips")
    private Truck truck;

    @OneToOne
    @JoinColumn(name="origin_facility_id")
    private Facility originFacility;

    @OneToOne
    @JoinColumn(name="destination_facility_id")
    private Facility destinationFacility;

    public Trip() { }

    public Trip(String tripIdentifier, LocalDateTime startDate, LocalDateTime endDate) {
        this.tripIdentifier = tripIdentifier;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long id) {
        this.tripId = id;
    }

    public String getTripIdentifier() {
        return tripIdentifier;
    }

    public void setTripIdentifier(String tripIdentifier) {
        this.tripIdentifier = tripIdentifier;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    public Facility getOriginFacility() {
        return originFacility;
    }

    public void setOriginFacility(Facility originFacility) {
        this.originFacility = originFacility;
    }

    public Facility getDestinationFacility() {
        return destinationFacility;
    }

    public void setDestinationFacility(Facility destinationFacility) {
        this.destinationFacility = destinationFacility;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "tripId=" + tripId +
                ", tripIdentifier='" + tripIdentifier + '\'' +
                ", truck=" + truck +
                ", originFacility=" + originFacility +
                ", destinationFacility=" + destinationFacility +
                '}';
    }
}
