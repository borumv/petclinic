package com.example.repositories;

import com.example.models.Pet;
import com.example.services.CrudService;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PetRepository extends CrudRepository<Pet, Long> {
    Optional<Pet> findByName(String name);
}
