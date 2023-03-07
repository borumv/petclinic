package com.example.bootstrap;

import com.example.models.*;
import com.example.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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
        owner1.setAddress("Rublevskaya street, 135-2");
        owner1.setCity("Borisov");
        owner1.setTelephone("+375294523164");
        Pet dogJack = new Pet();
        dogJack.setBirthdate(LocalDate.now());
        dogJack.setPetType(dog);
        dogJack.setName("Jack");
        dogJack.setOwner(owner1);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Roma");
        owner2.setLastName("Ruff");
        owner2.setAddress("Tashkenskaya street, 155-23");
        owner2.setCity("Minsk");
        owner2.setTelephone("+37529456464");
        Pet catBars = new Pet();
        catBars.setBirthdate(LocalDate.now());
        catBars.setPetType(cat);
        catBars.setName("Jack");
        catBars.setOwner(owner2);
        ownerService.save(owner2);

        System.out.println("Load owners...");



        Vet vet1 = new Vet();
        vet1.setFirstName("Michel");
        vet1.setLastName("Jordan");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Victor");
        vet2.setLastName("Kram");
        vetService.save(vet2);
        System.out.println("Load vets...");

        System.out.println(ownerService.findById(1L).getFirstName());
    }
}
