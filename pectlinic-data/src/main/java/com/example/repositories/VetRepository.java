package com.example.repositories;

import com.example.models.Vet;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VetRepository extends CrudRepository<Vet, Long> {
    Optional<Vet> findByLastName(String name);
}
