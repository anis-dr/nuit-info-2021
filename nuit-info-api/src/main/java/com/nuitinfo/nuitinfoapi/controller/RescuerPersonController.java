package com.nuitinfo.nuitinfoapi.controller;


import com.nuitinfo.nuitinfoapi.entities.RescuerPerson;
import com.nuitinfo.nuitinfoapi.repositories.RescuerPersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rescuer")
public class RescuerPersonController {
    final RescuerPersonRepository rescuerPersonRepository;

    public RescuerPersonController(RescuerPersonRepository rescuerPersonRepository) {
        this.rescuerPersonRepository = rescuerPersonRepository;
    }

    @GetMapping("/all")
    public List<RescuerPerson> getAll() {
        return rescuerPersonRepository.findAll();
    }

    @PostMapping("/add")
    public RescuerPerson addRescuerPerson(@RequestBody RescuerPerson rescuerPerson) {
        return rescuerPersonRepository.save(rescuerPerson);
    }

    @GetMapping("/get/{id}")
    public Optional<RescuerPerson> getRescuerPerson(@PathVariable Long id) {
        return rescuerPersonRepository.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRescuerPerson(@PathVariable Long id) {
        rescuerPersonRepository.deleteById(id);
    }

    // update rescuer person
    @PutMapping("/update/{id}")
    public RescuerPerson updateRescuerPerson(@PathVariable Long id, @RequestBody RescuerPerson rescuerPerson) {
        Optional<RescuerPerson> rescuerPersonToUpdateOption = rescuerPersonRepository.findById(id);
        if (rescuerPersonToUpdateOption.isPresent()) {
            RescuerPerson rescuerPersonToUpdate = rescuerPersonToUpdateOption.get();

            rescuerPersonToUpdate.setName(rescuerPerson.getName());
            rescuerPersonToUpdate.setLastName(rescuerPerson.getLastName());
            rescuerPersonToUpdate.setDateOfBirth(rescuerPerson.getDateOfBirth());
            rescuerPersonToUpdate.setNationality(rescuerPerson.getNationality());
            rescuerPersonRepository.save(rescuerPersonToUpdate);

            return rescuerPersonToUpdate;
        }

        return null;
    }

    // find by name
    @GetMapping("/find/{name}")
    public List<RescuerPerson> findByName(@PathVariable String name) {
        return rescuerPersonRepository.findByName(name);
    }

    // find by last name
    @GetMapping("/find/{lastName}")
    public List<RescuerPerson> findByLastName(@PathVariable String lastName) {
        return rescuerPersonRepository.findByLastName(lastName);
    }

    // find by name and last name
    @GetMapping("/find/{name}/{lastName}")
    public List<RescuerPerson> findByNameAndLastName(@PathVariable String name, @PathVariable String lastName) {
        return rescuerPersonRepository.findByNameAndLastName(name, lastName);
    }

}
