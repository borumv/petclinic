package com.example.services;

import com.example.models.Pet;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetServiceMap extends AbstractCrudServiceMap<Pet, Long> implements CrudService<Pet, Long> {


    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public void delete(Pet entity) {
        super.delete(entity);
    }

    @Override
    public Pet findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet save(Pet entity) {
        return super.save(entity);
    }
}
