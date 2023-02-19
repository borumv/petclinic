package com.example.services;

import java.util.*;


public abstract class AbstractCrudServiceMap<T, ID> {
    Map<ID, T> map = new HashMap();

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

    public T save(ID id, T entity){
        map.put(id, entity);
        return entity;
    }





}
