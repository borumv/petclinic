package com.example.services;

import com.example.models.Owner;
import com.example.models.Speciality;
import com.example.models.Vet;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractCrudServiceMap<Vet, Long> implements VetService{

    SpecialitiesService specialitiesService;

    public VetServiceMap(SpecialitiesService specialitiesService) {
        this.specialitiesService = specialitiesService;
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public void delete(Vet entity) {
        super.delete(entity);
    }

    @Override
    public Vet findByName(String name) {
        return null;
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
        if(entity.getSpecialities() != null){
            entity.getSpecialities().forEach(speciality -> {
                if(speciality.getId() == null){
                    Speciality savedSpeciality = specialitiesService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(entity);
    }
}
