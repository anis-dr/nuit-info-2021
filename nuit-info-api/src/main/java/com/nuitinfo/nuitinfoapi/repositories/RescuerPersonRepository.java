package com.nuitinfo.nuitinfoapi.repositories;

import com.nuitinfo.nuitinfoapi.entities.RescuerPerson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RescuerPersonRepository extends JpaRepository<RescuerPerson, Long> {

    @Override
    List<RescuerPerson> findAll();


    RescuerPerson findByName(String name);
    RescuerPerson findByLastName(String lastName);


}