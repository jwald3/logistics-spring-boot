package com.jwald.logisticplanning.services;

import com.jwald.logisticplanning.domain.Trip;
import com.jwald.logisticplanning.domain.Truck;
import com.jwald.logisticplanning.exception.BadRequestException;
import com.jwald.logisticplanning.exception.ResourceNotFoundException;
import com.jwald.logisticplanning.repository.TruckRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TruckService {

    @Autowired
    private final TruckRepository truckRepository;

    public List<Truck> getAllTrucks() {
        return truckRepository.findAll();
    }

    public Truck getTruckById(Long truckId) {
        if (!truckRepository.existsById(truckId)) {
            throw new ResourceNotFoundException(
                    "Truck with the id " + truckId + " does not exist"
            );
        }

        return truckRepository.findById(truckId).get();
    }

    public Truck addTruck(Truck truck) {
        Boolean licenseExists = truckRepository.licenseAlreadyExists(truck.getLicense());

        if (licenseExists) {
            throw new BadRequestException(
                    "License " + truck.getLicense() + " already taken"
            );
        }

        return truckRepository.save(truck);
    }

    public void deleteTruck(Long truckId) {
        if (!truckRepository.existsById(truckId)) {
            throw new ResourceNotFoundException(
                    "Truck with the id " + truckId + " does not exist"
            );
        }

        Truck truck = this.getTruckById(truckId);

        if (truck.getTrips().isEmpty()) {
            for (Trip trip: truck.getTrips()) {
                trip.setTruck(null);
            }

            truckRepository.deleteById(truckId);
        }


        truckRepository.deleteById(truckId);
    }

    public Truck updateTruck(Long truckId, Truck truck) {
        Truck currentTruck = truckRepository.findById(truckId)
                .orElseThrow(RuntimeException::new);

        currentTruck.setLicense(truck.getLicense());
        currentTruck.setCapacity(truck.getCapacity());

        return truckRepository.save(currentTruck);
    }
}
