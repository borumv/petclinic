package com.example.models;

import java.time.LocalDate;

public class Pet  extends BaseEntity{

    private String name;

    private PetType petType;

    private Owner owner;

    private LocalDate birthdate;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
