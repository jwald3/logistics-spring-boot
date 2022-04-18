package com.jwald.logisticplanning;

import com.jwald.logisticplanning.repository.FacilityRepository;
import com.jwald.logisticplanning.repository.TripRepository;
import com.jwald.logisticplanning.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogisticPlanningApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogisticPlanningApplication.class, args);
	}

	@Autowired
	private TruckRepository truckRepository;

	@Autowired
	private FacilityRepository facilityRepository;

	@Autowired
	private TripRepository tripRepository;

}
