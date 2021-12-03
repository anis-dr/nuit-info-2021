package com.nuitinfo.nuitinfoapi.repositories;

import com.nuitinfo.nuitinfoapi.entities.SavedPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavedPersonRepository extends JpaRepository<SavedPerson, Long> {
}