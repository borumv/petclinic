package com.example.repositories;

import com.example.models.Owner;
import com.example.services.CrudService;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Optional<Owner> findOwnerByLastName(String lastName);
    List<Owner> findOwnersByLastNameLike(String lastName);
}
