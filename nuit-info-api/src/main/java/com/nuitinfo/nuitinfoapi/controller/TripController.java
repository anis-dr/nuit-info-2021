package com.nuitinfo.nuitinfoapi.controller;

import com.nuitinfo.nuitinfoapi.dto.TripDTO;
import com.nuitinfo.nuitinfoapi.entities.RescuerPerson;
import com.nuitinfo.nuitinfoapi.entities.Trip;
import com.nuitinfo.nuitinfoapi.repositories.RescuerPersonRepository;
import com.nuitinfo.nuitinfoapi.repositories.TripRepository;
import com.nuitinfo.nuitinfoapi.services.TripService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/trips")
public class TripController {
    final TripRepository tripRepository;
    final RescuerPersonRepository rescuerPersonRepository;
    final TripService tripService;

    public TripController(TripRepository tripRepository, RescuerPersonRepository rescuerPersonRepository, TripService tripService) {
        this.tripRepository = tripRepository;
        this.rescuerPersonRepository = rescuerPersonRepository;
        this.tripService = tripService;
    }

    @GetMapping("/all")
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    // search by rescuer id
    @GetMapping("/search/rescuer/{id}")
    public List<Trip> searchByRescuerId(@PathVariable Long id) {
        RescuerPerson person = rescuerPersonRepository.getById(id);
        return person.getTrips();
    }

    // create a new trip
    @PostMapping("/add")
    public Trip createTrip(@RequestBody TripDTO tripTDO) {
        Trip trip = tripService.convertDtoToEntity(tripTDO);
        return tripRepository.save(trip);
    }

    // update a trip
    @PutMapping("/update")
    public Trip updateTrip(@RequestBody TripDTO tripTDO) {
        Trip trip = tripService.convertDtoToEntity(tripTDO);
        return tripRepository.save(trip);
    }
}
