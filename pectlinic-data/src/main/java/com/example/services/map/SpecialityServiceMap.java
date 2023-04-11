package com.example.services.map;

import com.example.models.Speciality;
import com.example.services.SpecialitiesService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class SpecialityServiceMap extends AbstractCrudServiceMap<Speciality, Long> implements SpecialitiesService {

}
