package com.example.services.map;

import com.example.models.Pet;
import com.example.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class PetServiceMap extends AbstractCrudServiceMap<Pet, Long> implements PetService {
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

    @Override
    public Pet findByName(String name) {
        return null;
    }
}
