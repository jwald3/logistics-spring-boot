package com.jwald.logisticplanning.repository;

import com.jwald.logisticplanning.domain.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {
}
