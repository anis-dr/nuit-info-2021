package com.nuitinfo.nuitinfoapi.controller;

import com.nuitinfo.nuitinfoapi.entities.SavedPerson;
import com.nuitinfo.nuitinfoapi.repositories.SavedPersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/saved")
public class SavedPersonController {
    final SavedPersonRepository savedPersonRepository;


    public SavedPersonController(SavedPersonRepository savedPersonRepository) {
        this.savedPersonRepository = savedPersonRepository;
    }

    @GetMapping()
    public List<SavedPerson> getAllSaved() {
        return savedPersonRepository.findAll();
    }


}
