package com.example.models;

import java.util.Set;

public class Vet extends Person{
    Set<Speciality> specialities;

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }

    public Set<Speciality> getSpecialities() {
        return specialities;
    }


}
