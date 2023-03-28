package com.example.services;

import com.example.models.Speciality;
import org.springframework.stereotype.Service;

@Service
public class SpecialityServiceMap extends AbstractCrudServiceMap<Speciality, Long> implements SpecialitiesService{

}
