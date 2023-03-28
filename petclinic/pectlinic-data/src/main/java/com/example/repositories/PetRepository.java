package com.example.repositories;

import com.example.models.Pet;
import com.example.services.CrudService;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
