package com.example.services;

import com.example.models.Pet;
import com.example.models.Vet;

import java.util.Set;

public interface VetService {


    Vet findByFirstName(String firstName);
    Vet findById(Long id);
    Set<Vet> findAll();
    Vet save(Vet person);
}
