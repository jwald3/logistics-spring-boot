package com.jwald.logisticplanning.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique = true)
    private String name;

    @Column(nullable=false)
    private String address;

    @Column(nullable=false)
    private String city;

    @Column(nullable=false)
    private String zipCode;

    @Column(nullable=false)
    private String state;

    public Facility(String name, String address, String city, String zipCode, String state) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.state = state;
    }
}
