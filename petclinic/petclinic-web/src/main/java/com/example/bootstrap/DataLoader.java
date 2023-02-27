package com.example.bootstrap;

import com.example.models.Owner;
import com.example.models.Vet;
import com.example.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;

    private final VetService vetService;
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Boris");
        owner1.setLastName("Vlasevsky");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Roma");
        owner2.setLastName("Ruff");
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
