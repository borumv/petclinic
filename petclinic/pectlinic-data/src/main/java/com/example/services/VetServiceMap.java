package com.example.services;

import com.example.models.Owner;
import com.example.models.Vet;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractCrudServiceMap<Vet, Long> implements VetService{
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
    public Vet save(Vet entity) {
        return super.save(entity);
    }
}
