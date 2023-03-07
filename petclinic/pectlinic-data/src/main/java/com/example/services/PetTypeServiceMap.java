package com.example.services;

import com.example.models.PetType;

public class PetTypeServiceMap extends AbstractCrudServiceMap<PetType, Long> implements PetTypeService{
    @Override
    public PetType save(PetType petType) {
        return super.save(petType);
    }
}
