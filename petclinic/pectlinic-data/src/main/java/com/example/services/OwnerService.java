package com.example.services;

import com.example.models.Owner;
import com.example.models.Person;

import java.util.Set;

public interface OwnerService {

    Owner findByFirstName(String firstName);
    Owner findById(Long id);
    Set<Owner> findAll();
    Owner save(Owner person);
}
