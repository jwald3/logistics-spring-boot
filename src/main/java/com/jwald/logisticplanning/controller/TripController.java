package com.jwald.logisticplanning.controller;

import com.jwald.logisticplanning.domain.Trip;
import com.jwald.logisticplanning.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/trips")
public class TripController {

    @Autowired
    private TripRepository tripRepository;

    @GetMapping("")
    public ResponseEntity<List<Trip>> getTrips() {
        List<Trip> trips = tripRepository.findAll();

        return ResponseEntity.ok(trips);
    }

    @PostMapping("")
    public Trip addTrip(@RequestBody Trip trip) {
        return tripRepository.save(trip);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trip> getTripById(@PathVariable Long id) {
        return ResponseEntity.ok(tripRepository.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trip> updateTrip(@PathVariable Long id, @RequestBody Trip trip) {
        Trip currentTrip = tripRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        currentTrip.setTripIdentifier(trip.getTripIdentifier());
        currentTrip.setStartDate(trip.getStartDate());
        currentTrip.setEndDate(trip.getEndDate());
        currentTrip.setOriginFacility(trip.getOriginFacility());
        currentTrip.setDestinationFacility(trip.getDestinationFacility());
        currentTrip.setTruck(trip.getTruck());

        Trip updatedTrip = tripRepository.save(currentTrip);

        return ResponseEntity.ok(updatedTrip);
    }

    @DeleteMapping("/{id}")
    public void deleteTripById(@PathVariable Long id) {
        tripRepository.deleteById(id);
    }
}
