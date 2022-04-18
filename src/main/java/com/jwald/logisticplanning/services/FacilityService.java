package com.jwald.logisticplanning.services;

import com.jwald.logisticplanning.domain.Facility;
import com.jwald.logisticplanning.exception.BadRequestException;
import com.jwald.logisticplanning.exception.ResourceNotFoundException;
import com.jwald.logisticplanning.repository.FacilityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FacilityService {

    private final FacilityRepository facilityRepository;

    public List<Facility> getAllFacilities() {
        return facilityRepository.findAll();
    }

    public Facility getFacilityById(Long facilityId) {
        if (!facilityRepository.existsById(facilityId)) {
            throw new ResourceNotFoundException(
                    "Facility with the id " + facilityId + " does not exist."
            );
        }

        return facilityRepository.findById(facilityId).get();
    }

    public Facility addFacility(Facility facility) {
        Boolean facilityNameTaken = facilityRepository.facilityNameAlreadyExists(facility.getName());

        if (facilityNameTaken) {
            throw new BadRequestException(
                    "The name " + facility.getName() + " is already taken"
            );
        }

        return facilityRepository.save(facility);
    }

    public void deleteFacility(Long facilityId) {
        if (!facilityRepository.existsById(facilityId)) {
            throw new ResourceNotFoundException(
                    "Facility with the id " + facilityId + " does not exist."
            );
        }

        facilityRepository.deleteById(facilityId);
    }

    public Facility updateFacility(Long facilityId, Facility facility) {
        if (!facilityRepository.existsById(facilityId)) {
            throw new ResourceNotFoundException(
                    "Facility with the id " + facilityId + " does not exist."
            );
        }

        Facility currentFacility = facilityRepository.findById(facilityId).get();
        currentFacility.setName(facility.getName());
        currentFacility.setAddress(facility.getAddress());
        currentFacility.setCity(facility.getCity());
        currentFacility.setState(facility.getState());
        currentFacility.setZipCode(facility.getZipCode());

        return facilityRepository.save(currentFacility);
    }
}
