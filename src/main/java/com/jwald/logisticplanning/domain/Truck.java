package com.jwald.logisticplanning.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
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

    public Truck(String license, Long capacity) {
        this.license = license;
        this.capacity = capacity;
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
