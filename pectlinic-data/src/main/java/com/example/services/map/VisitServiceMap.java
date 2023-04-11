package com.example.services.map;

import com.example.models.Visit;
import com.example.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VisitServiceMap extends AbstractCrudServiceMap<Visit, Long> implements VisitService {
    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
    @Override
    public void delete(Visit entity) {
        super.delete(entity);
    }

    @Override
    public Visit findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit save(Visit visit) {
        if(visit.getPet() == null || visit.getPet().getId() ==null || visit.getPet().getOwner() == null || visit.getPet().getOwner().getId() == null){
            throw new RuntimeException("Runtime error. Check your visit");
        }
        return super.save(visit);
    }

    @Override
    public Long getNextId() {
        return super.getNextId();
    }
}
