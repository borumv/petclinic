package com.example.services;

import com.example.models.Owner;

import java.util.Set;

public interface CrudService <T, ID>{
    T findByName(String name);
    T findById(ID id);
    Set<T> findAll();
    T save(T person);

    void delete(T object);

    void deleteById(ID id);

}
