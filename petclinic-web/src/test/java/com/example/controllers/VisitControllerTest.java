package com.example.controllers;

import com.example.models.Owner;
import com.example.models.Pet;
import com.example.models.PetType;
import com.example.services.OwnerService;
import com.example.services.VisitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class VisitControllerTest {

    MockMvc mockMvc;

    @Mock
    OwnerService ownerService;
    @Mock
    VisitService visitService;
    @InjectMocks
    VisitController visitController;

    private final UriTemplate visitUriTemplate = new UriTemplate("/owners/{ownerId}/pets/{petId}/visits/new");
    private final Map<String, String> uriParams = new HashMap<>();

    private URI url;

    Owner owner;
    Pet pet;


    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(visitController).build();
        pet = Pet.builder()
                .id(1L)
                .name("Bobik")
                .petType(PetType.builder()
                        .id(2L)
                        .name("cat")
                        .build()
                )
                        .visits(new HashSet<>())
                                .build();


        when(ownerService.findById(anyLong())).thenReturn(
                Owner.builder()
                        .id(1L)
                        .lastName("Vlasevsky")
                        .firstName("Boris")
                        .city("Minsk")
                        .pets(Set.of(pet))
                        .build()
        );
        uriParams.clear();
        uriParams.put("ownerId", "1");
        uriParams.put("petId", "1");
        url = visitUriTemplate.expand(uriParams);


    }

    @Test
    void findOwner() throws Exception {
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(view()
                        .name("pets/createOrUpdateVisitForm"));
    }

    @Test
    void processNewVisitForm() throws Exception {
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("date", "2022-12-12")
                        .param("description", "my desctiprion!!"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/{ownerId}"))
                .andExpect(model().hasNoErrors());
        verify(visitService, times(1)).save(any());
    }
}