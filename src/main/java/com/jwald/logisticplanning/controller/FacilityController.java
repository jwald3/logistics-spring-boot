package com.jwald.logisticplanning.controller;

import com.jwald.logisticplanning.domain.Facility;
import com.jwald.logisticplanning.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/facilities")
public class FacilityController {

    @Autowired
    private FacilityRepository facilityRepository;

    @GetMapping("")
    public ResponseEntity<List<Facility>> getFacilities() {
        List<Facility> facilities = facilityRepository.findAll();

        return ResponseEntity.ok(facilities);
    }

    @PostMapping("")
    public ResponseEntity<Facility> addFacility(@RequestBody Facility facility) {
        Facility newFacility = facilityRepository.save(facility);

        return ResponseEntity.ok(newFacility);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Facility> getFacilityById(@PathVariable Long id){
        Facility facility = facilityRepository.findById(id).orElseThrow(RuntimeException::new);

        return ResponseEntity.ok(facility);
    }

    @DeleteMapping("/{id}")
    public void deleteFacilityById(@PathVariable Long id){
        facilityRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Facility> updateFacility(@PathVariable Long id, @RequestBody Facility facility){
        Facility currentFacility = facilityRepository.findById(id).orElseThrow(RuntimeException::new);

        currentFacility.setName(facility.getName());
        currentFacility.setAddress(facility.getAddress());
        currentFacility.setCity(facility.getCity());
        currentFacility.setState(facility.getState());
        currentFacility.setZipCode(facility.getZipCode());

        Facility updatedFacility = facilityRepository.save(currentFacility);

        return ResponseEntity.ok(updatedFacility);
    }
}
