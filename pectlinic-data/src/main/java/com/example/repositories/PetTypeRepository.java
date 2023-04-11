package com.example.repositories;

import com.example.models.PetType;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
    Optional<PetType> findByName(String name);
}
