package com.jwald.logisticplanning.repository;

import com.jwald.logisticplanning.domain.Facility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityRepository extends JpaRepository<Facility, Long> {
}
