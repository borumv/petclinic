package com.example.services;

import com.example.models.Owner;

import java.util.Set;

public interface CrudService <T, ID>{
    T findById(ID id);
    Set<T> findAll();
    T save(ID id, T person);
}
