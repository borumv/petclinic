package com.example.models;

import jakarta.persistence.MappedSuperclass;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@MappedSuperclass
public class Person extends BaseEntity{

    public Person(Long id, String firstName, String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }
    private String firstName;
    private String lastName;

}
