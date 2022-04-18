package com.jwald.logisticplanning.controller;

import com.jwald.logisticplanning.domain.Trip;
import com.jwald.logisticplanning.services.TripService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://master.d15g9lsuyp8iqp.amplifyapp.com")
@RestController
@AllArgsConstructor
@RequestMapping("api/trips")
public class TripController {

    private TripService tripService;

    @GetMapping("")
    public ResponseEntity<List<Trip>> getTrips() {
        List<Trip> trips = tripService.getAllTrips();

        return ResponseEntity.ok(trips);
    }

    @PostMapping("")
    public Trip addTrip(@RequestBody Trip trip) {
        return tripService.addTrip(trip);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trip> getTripById(@PathVariable Long id) {
        return ResponseEntity.ok(tripService.getTripById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trip> updateTrip(@PathVariable Long id, @RequestBody Trip trip) {
        Trip updatedTrip = tripService.updateTrip(id, trip);

        return ResponseEntity.ok(updatedTrip);
    }

    @DeleteMapping("/{id}")
    public void deleteTripById(@PathVariable Long id) {
        tripService.deleteTrip(id);
    }
}
