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

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Boris");
        owner1.setLastName("Vlasevsky");
        ownerService.save(owner1.getId(), owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Roma");
        owner2.setLastName("Ruff");
        ownerService.save(owner2.getId(), owner2);

        System.out.println("Load owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Michel");
        vet1.setLastName("Jordan");
        vetService.save(vet1.getId(), vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Victor");
        vet2.setLastName("Kram");
        vetService.save(vet2.getId(), vet2);
        System.out.println("Load vets...");
    }
}
