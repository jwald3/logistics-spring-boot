package com.jwald.logisticplanning.controller;

import com.jwald.logisticplanning.domain.Trip;
import com.jwald.logisticplanning.domain.Truck;
import com.jwald.logisticplanning.repository.TruckRepository;
import com.jwald.logisticplanning.services.TruckService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/trucks")
@AllArgsConstructor
public class TruckController {

    private TruckRepository truckRepository;
    private TruckService truckService;

    @GetMapping("")
    public ResponseEntity<List<Truck>> getTrucks() {
        List<Truck> trucks = truckService.getAllTrucks();
        return ResponseEntity.ok(trucks);
    }

    @PostMapping("")
    public ResponseEntity<Truck> addTruck(@RequestBody Truck truck) {
        Truck newTruck = truckService.addTruck(truck);
        return ResponseEntity.ok(newTruck);
    }

    @GetMapping("/{id}")
    public Truck getTruckById(@PathVariable Long id) {
        return truckService.getTruckById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTruckById(@PathVariable Long id) {
        truckService.deleteTruck(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Truck> updateTruck(@PathVariable Long id, @RequestBody Truck truck) {
        Truck updatedTruck = truckService.updateTruck(id, truck);

        return ResponseEntity.ok(updatedTruck);
    }
}
