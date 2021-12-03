package com.nuitinfo.nuitinfoapi.services;

import com.nuitinfo.nuitinfoapi.dto.TripDTO;
import com.nuitinfo.nuitinfoapi.entities.RescuerPerson;
import com.nuitinfo.nuitinfoapi.entities.Trip;
import com.nuitinfo.nuitinfoapi.repositories.RescuerPersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {
    final RescuerPersonRepository rescuerPersonRepository;

    public TripService(RescuerPersonRepository rescuerPersonRepository) {
        this.rescuerPersonRepository = rescuerPersonRepository;
    }

    private TripDTO convertEntityToDto(Trip trip) {
        TripDTO tripDTO = new TripDTO();
        trip.getRescuers().forEach(rescuer -> tripDTO.getRescuersIds().add(rescuer.getId()));

        return tripDTO;
    }

    public Trip convertDtoToEntity(TripDTO tripDTO) {
        Trip trip = new Trip();

        List<Long> rescuerPersonIds = tripDTO.getRescuersIds();
        rescuerPersonIds.forEach(rescuerId -> {
            Optional<RescuerPerson> rescuerPerson = rescuerPersonRepository.findById(rescuerId);
            rescuerPerson.ifPresent(person -> trip.getRescuers().add(person));
        });

        return trip;
    }

}
