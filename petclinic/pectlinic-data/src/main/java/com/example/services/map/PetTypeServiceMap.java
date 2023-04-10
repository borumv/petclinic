package com.example.services.map;

import com.example.models.PetType;
import com.example.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetTypeServiceMap extends AbstractCrudServiceMap<PetType, Long> implements PetTypeService {
    @Override
    public PetType save(PetType petType) {
        return super.save(petType);
    }
}
