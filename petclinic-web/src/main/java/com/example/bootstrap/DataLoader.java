package com.example.bootstrap;

import com.example.models.*;
import com.example.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    private  final VisitService visitService;
    private final SpecialitiesService specialitiesService;
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, VisitService visitService, SpecialitiesService specialitiesService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.visitService = visitService;
        this.specialitiesService = specialitiesService;
    }

    @Override
    public void run(String... args) throws Exception {

        loadData();
    }


    private void loadData() {
        System.out.println("Start to load data");
        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCat = petTypeService.save(cat);

        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDog = petTypeService.save(dog);

        Speciality radiology = new Speciality("Raiology");
        Speciality savedRadiology = specialitiesService.save(radiology);
        Speciality surgery = new Speciality("Surgery");
        Speciality savedSurgery = specialitiesService.save(surgery);
        Speciality dentistry = new Speciality("Dentistry");
        Speciality savedDentisry = specialitiesService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Boris");
        owner1.setLastName("Vlasevsky");
        owner1.setAddress("Rublevskaya street, 135-2");
        owner1.setCity("Borisov");
        owner1.setTelephone("+375294523164");
        Pet dogJack = new Pet();
        dogJack.setBirthdate(LocalDate.now());
        dogJack.setPetType(savedDog);
        dogJack.setName("Jack");
        dogJack.setOwner(owner1);
        owner1.getPets().add(dogJack);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Roma");
        owner2.setLastName("Ruff");
        owner2.setAddress("Tashkenskaya street, 155-23");
        owner2.setCity("Minsk");
        owner2.setTelephone("+37529456464");

        Pet catBars = new Pet();
        catBars.setBirthdate(LocalDate.now());
        catBars.setPetType(savedCat);
        catBars.setName("Bars");
        catBars.setOwner(owner2);
        owner2.getPets().add(catBars);
        ownerService.save(owner2);

        Pet dogPit = new Pet();
        dogPit.setBirthdate(LocalDate.now());
        dogPit.setPetType(savedCat);
        dogPit.setName("Pit");
        dogPit.setOwner(owner1);
        owner2.getPets().add(dogPit);
        ownerService.save(owner1);


        Visit catBarsVisit = new Visit();
        catBarsVisit.setDate(LocalDate.now());
        catBarsVisit.setDescription("caughing cat");
        catBarsVisit.setPet(catBars);
        visitService.save(catBarsVisit);


        Vet vet1 = new Vet();
        vet1.setFirstName("Michel");
        vet1.setLastName("Jordan");
        vet1.getSpecialities().add(savedRadiology);
        vet1.getSpecialities().add(savedDentisry);
        vetService.save(vet1);


        Vet vet2 = new Vet();
        vet2.setFirstName("Victor");
        vet2.setLastName("Kram");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);
        System.out.println("End load data...");

//        System.out.println("total count Pets - " + ownerService.findAll().stream().map(item -> item.getPets().size()).reduce(Integer::sum).get());
//        System.out.println("total count Owners - " + (long) ownerService.findAll().size());
//        System.out.println("total count Vets - " + vetService.findAll().size());
//        System.out.println("total count Specialities - " + specialitiesService.findAll().size());
    }
}
