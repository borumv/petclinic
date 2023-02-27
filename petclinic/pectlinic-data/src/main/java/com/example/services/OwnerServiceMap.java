package com.example.services;

import com.example.models.Owner;
import com.example.models.Pet;

import java.util.Set;

public class OwnerServiceMap extends AbstractCrudServiceMap<Owner, Long> implements OwnerService{
    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public void delete(Owner entity) {
        super.delete(entity);
    }

    @Override
    public Owner findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner save(Long aLong, Owner entity) {
        return super.save(aLong, entity);
    }
}
