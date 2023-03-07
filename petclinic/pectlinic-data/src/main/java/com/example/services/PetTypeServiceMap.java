package com.example.services;

import com.example.models.PetType;
import org.springframework.stereotype.Service;

@Service
public class PetTypeServiceMap extends AbstractCrudServiceMap<PetType, Long> implements PetTypeService{
    @Override
    public PetType save(PetType petType) {
        return super.save(petType);
    }
}
