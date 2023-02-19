package com.example.services;

import com.example.models.Owner;
import com.example.models.Vet;

import java.util.Set;

public class VetServiceMap extends AbstractCrudServiceMap<Vet, Long> implements CrudService<Vet, Long>{
    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public void delete(Vet entity) {
        super.delete(entity);
    }

    @Override
    public Vet findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }


    @Override
    public Vet save(Long aLong, Vet entity) {
        return super.save(aLong, entity);
    }
}
