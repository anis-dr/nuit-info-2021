package com.nuitinfo.nuitinfoapi.repositories;

import com.nuitinfo.nuitinfoapi.entities.SavedPerson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SavedPersonRepository extends JpaRepository<SavedPerson, Long> {
    List<SavedPerson> findByName(String name);

    List<SavedPerson> findByLastName(String lastName);

    List<SavedPerson> findByNameAndLastName(String name, String lastName);
}