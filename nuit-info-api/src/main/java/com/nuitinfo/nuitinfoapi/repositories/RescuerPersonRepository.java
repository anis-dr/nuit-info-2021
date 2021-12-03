package com.nuitinfo.nuitinfoapi.repositories;

import com.nuitinfo.nuitinfoapi.entities.RescuerPerson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RescuerPersonRepository extends JpaRepository<RescuerPerson, Long> {
    List<RescuerPerson> findByName(String name);
    List<RescuerPerson> findByLastName(String lastName);
    List<RescuerPerson> findByNameAndLastName(String name, String lastName);
}