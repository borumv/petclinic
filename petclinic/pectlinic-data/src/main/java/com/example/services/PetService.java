package com.example.services;

import com.example.models.Pet;

import java.util.Set;

public interface PetService {
    Pet findByFirstName(String firstName);
    Pet findById(Long id);
    Set<Pet> findAll();
    Pet save(Pet person);
}
