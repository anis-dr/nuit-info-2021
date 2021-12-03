package com.nuitinfo.nuitinfoapi.controller;


import com.nuitinfo.nuitinfoapi.repositories.RescuerPersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nuitinfo.nuitinfoapi.entities.RescuerPerson;

import java.util.List;

@RestController
@RequestMapping("/rescuer")
public class RescuerPersonController {
    final RescuerPersonRepository rescuerPersonRepository;

    public RescuerPersonController(RescuerPersonRepository rescuerPersonRepository) {
        this.rescuerPersonRepository = rescuerPersonRepository;
    }

    @GetMapping()
    public List<RescuerPerson> getAll(){
        return rescuerPersonRepository.findAll();
    }

}
