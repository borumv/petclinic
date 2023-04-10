package com.example.services.map;

import com.example.models.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    Long id = 1L;
    String lastName = "Vlasevsky";

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetServiceMap(), new PetTypeServiceMap());
        ownerServiceMap.save(Owner.builder().id(id).lastName(lastName).build());

    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(id);
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {

        ownerServiceMap.delete(ownerServiceMap.findById(id));
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(id);
        assertNotNull(owner);
        assertEquals(id, owner.getId());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void save() {
        Owner owner_second = Owner.builder().id(2L).build();
        assertNotNull(owner_second);
        assertEquals(2, owner_second.getId());
    }

    @Test
    void findByName() {
        Owner owner = ownerServiceMap.findByName(lastName);
        assertEquals(lastName, owner.getLastName());
    }

    @Test
    void findWhereNameIsNone() {
        Owner owner = ownerServiceMap.findByName("foo");
        assertNull(owner);
    }
}