package com.jwald.logisticplanning.repository;

import com.jwald.logisticplanning.domain.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FacilityRepository extends JpaRepository<Facility, Long> {

    @Query("" +
            "SELECT CASE WHEN COUNT(f) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM Facility f " +
            "WHERE f.name = ?1"
    )
    Boolean facilityNameAlreadyExists(String name);
}
