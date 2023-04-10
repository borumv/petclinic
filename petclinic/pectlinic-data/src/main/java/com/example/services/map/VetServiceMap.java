package com.example.services.map;

import com.example.models.Speciality;
import com.example.models.Vet;
import com.example.services.SpecialitiesService;
import com.example.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractCrudServiceMap<Vet, Long> implements VetService {

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
