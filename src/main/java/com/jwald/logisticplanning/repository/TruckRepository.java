package com.jwald.logisticplanning.repository;

import com.jwald.logisticplanning.domain.Truck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TruckRepository extends JpaRepository<Truck, Long> {

    @Query("" +
            "SELECT CASE WHEN COUNT(t) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM Truck t " +
            "WHERE t.license = ?1"
    )
    Boolean licenseAlreadyExists(String license);
}
