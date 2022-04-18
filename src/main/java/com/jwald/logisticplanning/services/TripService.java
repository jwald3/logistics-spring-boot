package com.jwald.logisticplanning.services;

import com.jwald.logisticplanning.domain.Trip;
import com.jwald.logisticplanning.exception.BadRequestException;
import com.jwald.logisticplanning.exception.ResourceNotFoundException;
import com.jwald.logisticplanning.repository.TripRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TripService {

    @Autowired
    private final TripRepository tripRepository;

    public List<Trip> getAllTrips() { return tripRepository.findAll(); }

    public Trip getTripById(Long tripId) {
        if (!tripRepository.existsById(tripId)) {
            throw new ResourceNotFoundException(
                    "Trip with the id " + tripId + " does not exist"
            );
        }

        return tripRepository.getById(tripId);
    }

    public Trip addTrip(Trip trip) {
        Boolean identifierExists = tripRepository.identifierAlreadyExists(trip.getTripIdentifier());

        if (identifierExists) {
            throw new BadRequestException(
                    "Identifier " + trip.getTripIdentifier() + " already in use"
            );
        }

        return tripRepository.save(trip);
    }

    public void deleteTrip(Long tripId) {
        if(!tripRepository.existsById(tripId)) {
            throw new ResourceNotFoundException(
                    "Trip with the id " + tripId + " does not exist"
            );
        }

        tripRepository.deleteById(tripId);
    }

    public Trip updateTrip(Long tripId, Trip trip) {
        if (!tripRepository.existsById(tripId)) {
            throw new ResourceNotFoundException(
                    "Trip with the id " + tripId + " does not exist"
            );
        }

        Trip currentTrip = tripRepository.getById(tripId);

        currentTrip.setTripIdentifier(trip.getTripIdentifier());
        currentTrip.setStartDate(trip.getStartDate());
        currentTrip.setEndDate(trip.getEndDate());
        currentTrip.setOriginFacility(trip.getOriginFacility());
        currentTrip.setDestinationFacility(trip.getDestinationFacility());
        currentTrip.setTruck(trip.getTruck());

        return tripRepository.save(currentTrip);
    }
}
