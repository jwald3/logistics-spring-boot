package com.jwald.logisticplanning.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@ToString
@Getter
@Setter
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

    public Trip(String tripIdentifier, LocalDateTime startDate, LocalDateTime endDate) {
        this.tripIdentifier = tripIdentifier;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
