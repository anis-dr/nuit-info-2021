package com.nuitinfo.nuitinfoapi.controller;

import com.nuitinfo.nuitinfoapi.entities.RescuerPerson;
import com.nuitinfo.nuitinfoapi.entities.SavedPerson;
import com.nuitinfo.nuitinfoapi.repositories.SavedPersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/saved")
public class SavedPersonController {
    final SavedPersonRepository savedPersonRepository;


    public SavedPersonController(SavedPersonRepository savedPersonRepository) {
        this.savedPersonRepository = savedPersonRepository;
    }

    @GetMapping("/all")
    public List<SavedPerson> getAll() {
        return savedPersonRepository.findAll();
    }

    @PostMapping("/add")
    public SavedPerson addRescuerPerson(@RequestBody SavedPerson savedPerson) {
        return savedPersonRepository.save(savedPerson);
    }

    @GetMapping("/get/{id}")
    public Optional<SavedPerson> getRescuerPerson(@PathVariable Long id) {
        return savedPersonRepository.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRescuerPerson(@PathVariable Long id) {
        savedPersonRepository.deleteById(id);
    }

    // update rescuer person
    @PutMapping("/update/{id}")
    public SavedPerson updateRescuerPerson(@PathVariable Long id, @RequestBody RescuerPerson rescuerPerson) {
        Optional<SavedPerson> savedPersonToUpdateOption = savedPersonRepository.findById(id);
        if (savedPersonToUpdateOption.isPresent()) {
            SavedPerson savedPersonToUpdate = savedPersonToUpdateOption.get();

            savedPersonToUpdate.setName(rescuerPerson.getName());
            savedPersonToUpdate.setLastName(rescuerPerson.getLastName());
            savedPersonToUpdate.setDateOfBirth(rescuerPerson.getDateOfBirth());
            savedPersonToUpdate.setNationality(rescuerPerson.getNationality());
            savedPersonRepository.save(savedPersonToUpdate);

            return savedPersonToUpdate;
        }

        return null;
    }

    // find by name
    @GetMapping("/findByName/{name}")
    public List<SavedPerson> findByName(@PathVariable String name) {
        return savedPersonRepository.findByName(name);
    }

    // find by last name
    @GetMapping("/findByLastName/{lastName}")
    public List<SavedPerson> findByLastName(@PathVariable String lastName) {
        return savedPersonRepository.findByLastName(lastName);
    }

    // find by name and last name
    @GetMapping("/findByNameAndLastName/{name}/{lastName}")
    public List<SavedPerson> findByNameAndLastName(@PathVariable String name, @PathVariable String lastName) {
        return savedPersonRepository.findByNameAndLastName(name, lastName);
    }
}
