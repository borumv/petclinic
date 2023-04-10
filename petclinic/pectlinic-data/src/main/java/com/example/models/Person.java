package com.example.models;

import jakarta.persistence.MappedSuperclass;
import lombok.*;

@Data
@MappedSuperclass
public class Person extends BaseEntity{
    private String firstName;
    private String lastName;

}
