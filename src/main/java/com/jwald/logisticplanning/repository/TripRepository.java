package com.jwald.logisticplanning.repository;

import com.jwald.logisticplanning.domain.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TripRepository extends JpaRepository<Trip, Long> {

    @Query("" +
            "SELECT CASE WHEN COUNT(t) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM Trip t " +
            "WHERE t.tripIdentifier = ?1"
    )
    Boolean identifierAlreadyExists(String tripIdentifier);
}
