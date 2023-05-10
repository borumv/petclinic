package com.example.controllers;

import com.example.models.Owner;
import com.example.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockReset;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.*;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnerController ownerController;
    MockMvc mockMvc;

    Set<Owner> ownerSet;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
        ownerSet = new HashSet<>();
        ownerSet.add(Owner.builder().id(1L).lastName("John").build());
        ownerSet.add(Owner.builder().id(2L).lastName("Boris").build());
    }

    @Test
    void findOwners() throws Exception {
        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/findOwners"));
        verifyNoInteractions(ownerService);

    }

    @Test
    void processFormWithManyOwners() throws Exception {
        when(ownerService.findOwnersByLastNameLike(anyString()))
                .thenReturn(Arrays.asList(Owner.builder().id(1L).build(), Owner.builder().id(2L).build()));

        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownersList"))
                .andExpect(model().attribute("listOwners", hasSize(2)));
    }

    @Test
    void processFormWithManyOwnersWithEmptyParam() throws Exception {
        when(ownerService.findOwnersByLastNameLike(anyString()))
                .thenReturn(Arrays.asList(Owner.builder().id(1L).build(), Owner.builder().id(2L).build()));

        mockMvc.perform(get("/owners")
                        .param("lastName", ""))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownersList"))
                .andExpect(model().attribute("listOwners", hasSize(2)));
    }


    @Test
    void showOwner() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(Owner.builder().id(123L).build());
        mockMvc.perform(get("/owners/123"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownerDetails"))
                .andExpect(model().attribute("owner", hasProperty("id", is(123L))));
    }

    @Test
    void initCreationForm() throws Exception {
        mockMvc.perform(get("/owners/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/createOrUpdateOwnerForm"))
                .andExpect(model().attributeExists("owner"));
        verifyNoInteractions(ownerService);
    }

    @Test
    void processCreationForm() throws Exception {
       when(ownerService.save(any())).thenReturn(Owner.builder().id(1L).build());
       mockMvc.perform(post("/owners/new"))
               .andExpect(status().is3xxRedirection())
               .andExpect(view().name("redirect:/owners/1"));
    }

    @Test
    void initUpdateForm() throws Exception {
        when(ownerService.findById(1L)).thenReturn(Owner.builder().id(1L).build());
        mockMvc.perform(get("/owners/1/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/createOrUpdateOwnerForm"))
                .andExpect(model().attributeExists("owner"));

    }

    @Test
    void processUpdateForm() throws Exception {
        when(ownerService.save(any())).thenReturn(Owner.builder().id(1L).build());
        mockMvc.perform(post("/owners/1/edit"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));
    }

}