package com.example.repositories;

import com.example.models.Speciality;
import com.example.services.CrudService;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
