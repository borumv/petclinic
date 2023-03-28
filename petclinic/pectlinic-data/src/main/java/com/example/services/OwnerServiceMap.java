package com.example.services;

import com.example.models.Owner;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractCrudServiceMap<Owner, Long> implements OwnerService{
    private PetService petService;

    private PetTypeService petTypeService;
    public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }
    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public void delete(Owner entity) {
        super.delete(entity);
    }

    @Override
    public Owner findByName(String name) {
        return null;
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
    public Owner save(Owner entity) {
        if(entity != null){
            entity.getPets().forEach(pet ->{
                if(pet.getPetType() != null){
                    if(pet.getPetType().getId() == null){
                        petTypeService.save(pet.getPetType());
                    }
                }else {
                    throw new RuntimeException("Type is required");
                }
                if(pet.getId() == null){
                    petService.save(pet);
                }
            });
        }


        return super.save(entity);
    }
}
