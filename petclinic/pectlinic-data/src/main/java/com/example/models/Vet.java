package com.example.models;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person{
    Set<Speciality> specialities = new HashSet<>();

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }

    public Set<Speciality> getSpecialities() {
        return specialities;
    }


}
