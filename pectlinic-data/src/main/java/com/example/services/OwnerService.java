package com.example.services;

import com.example.models.Owner;
import com.example.models.Person;

import java.util.List;
import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByName(String name);
    List<Owner> findOwnersByLastNameLike(String lastName);
}

