package com.example.services.springdatajpa;

import com.example.models.Owner;
import com.example.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    static final Long ID = 1L;
    static final String JOHN = "John";
    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    Owner returnedOwner;

    @BeforeEach
    void setUp() {
        returnedOwner = Owner.builder().id(ID).lastName(JOHN).build();
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnedOwner));
        Owner owner = ownerSDJpaService.findById(ID);
        assertNotNull(owner);
        verify(ownerRepository).findById(anyLong());
        assertEquals(ID, owner.getId());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(returnedOwner);
        ownerSet.add(Owner.builder().id(2L).build());
        when(ownerRepository.findAll()).thenReturn(ownerSet);
        assertEquals(2, ownerSDJpaService.findAll().size());
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(returnedOwner);
        Owner owner = ownerSDJpaService.save(returnedOwner);
        assertNotNull(owner);
        assertEquals(ID, owner.getId());
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(returnedOwner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(ID);
        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void findByName() {
        when(ownerRepository.findOwnerByLastName(any())).thenReturn(Optional.of(returnedOwner));
        Owner owner = ownerSDJpaService.findByName("hello");
        verify(ownerRepository).findOwnerByLastName(any());
        assertEquals(JOHN, owner.getLastName());
    }
}