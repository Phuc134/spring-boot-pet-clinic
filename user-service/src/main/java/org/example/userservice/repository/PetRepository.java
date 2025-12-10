package org.example.userservice.repository;

import org.example.userservice.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Integer> {
    List<Pet> findByName(String name);
    List<Pet> findByBirthDate(LocalDate date);
}
