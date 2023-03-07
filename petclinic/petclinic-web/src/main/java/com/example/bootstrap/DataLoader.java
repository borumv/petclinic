package com.example.bootstrap;

import com.example.models.Owner;
import com.example.models.PetType;
import com.example.models.Speciality;
import com.example.models.Vet;
import com.example.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType cat = new PetType();
        cat.setName("cat");
        petTypeService.save(cat);

        PetType dog = new PetType();
        dog.setName("dog");
        petTypeService.save(dog);


        Owner owner1 = new Owner();
        owner1.setFirstName("Boris");
        owner1.setLastName("Vlasevsky");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Roma");
        owner2.setLastName("Ruff");
        ownerService.save(owner2);

        System.out.println("Load owners...");

        Set<Speciality> specialities = new HashSet<>();
        specialities.add(new Speciality("Dantist"));
        specialities.add(new Speciality("Newrolog"));

        Vet vet1 = new Vet(specialities);
        vet1.setFirstName("Michel");
        vet1.setLastName("Jordan");
        vetService.save(vet1);

        Vet vet2 = new Vet(specialities);
        vet2.setFirstName("Victor");
        vet2.setLastName("Kram");
        vetService.save(vet2);
        System.out.println("Load vets...");

        System.out.println(ownerService.findById(1L).getFirstName());
    }
}
