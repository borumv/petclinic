package com.example.services;

import com.example.models.Pet;

import java.util.Set;

public interface PetService extends CrudService<Pet, Long> {
    Pet findByFirstName(String firstName);

}
