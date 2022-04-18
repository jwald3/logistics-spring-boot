package com.jwald.logisticplanning.controller;

import com.jwald.logisticplanning.domain.Facility;
import com.jwald.logisticplanning.services.FacilityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://master.d15g9lsuyp8iqp.amplifyapp.com")
@RestController
@AllArgsConstructor
@RequestMapping("api/facilities")
public class FacilityController {

    private FacilityService facilityService;

    @GetMapping("")
    public ResponseEntity<List<Facility>> getFacilities() {
        List<Facility> facilities = facilityService.getAllFacilities();

        return ResponseEntity.ok(facilities);
    }

    @PostMapping("")
    public ResponseEntity<Facility> addFacility(@RequestBody Facility facility) {
        Facility newFacility = facilityService.addFacility(facility);

        return ResponseEntity.ok(newFacility);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Facility> getFacilityById(@PathVariable Long id){
        Facility facility = facilityService.getFacilityById(id);

        return ResponseEntity.ok(facility);
    }

    @DeleteMapping("/{id}")
    public void deleteFacilityById(@PathVariable Long id){
        facilityService.deleteFacility(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Facility> updateFacility(@PathVariable Long id, @RequestBody Facility facility){
        Facility updatedFacility = facilityService.updateFacility(id, facility);

        return ResponseEntity.ok(updatedFacility);
    }
}
