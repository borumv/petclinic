package com.example.models;

import java.util.Set;

public class Vet extends Person{
    Set<Speciality> specialities;

    public Vet(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
