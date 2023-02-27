package com.example.services;

import com.example.models.BaseEntity;

import java.util.*;


public abstract class AbstractCrudServiceMap<T extends BaseEntity, ID extends Long> {
    Map<Long, T> map = new HashMap();

    public void deleteById(ID id){
        map.remove(id);
    }

    public void delete(T entity){
        map.entrySet().removeIf(item -> item.equals(entity));
    }

    public T findById(ID id){
        return map.get(id);
    }

    public Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    public T save(T entity){
        if(entity != null){
            if(entity.getId() == null){
                entity.setId(getNextId());
            }
            map.put(entity.getId(), entity);
        }else {
            System.out.println("Entity can't be null");
        }

        return entity;
    }

    public Long getNextId(){
        Long nextId = null;
        try{
            nextId = Collections.max(map.keySet()) + 1L;
        }catch (NoSuchElementException e){
            nextId = 1L;
        }
        return nextId;
    }





}
