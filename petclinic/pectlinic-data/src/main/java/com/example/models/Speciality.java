package com.example.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Entity
@Table(name = "specialities")

public class Speciality extends BaseEntity{
    @Column(name = "description")
    private String description;
    public Speciality() {
    }

    public Speciality(String description) {
        this.description = description;
    }
}
