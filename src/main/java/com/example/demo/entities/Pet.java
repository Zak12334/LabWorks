package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pets")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "animal_type")
    private String animalType;

    private String breed;

    private int age;

    @ManyToOne
    @JoinColumn(name = "household_eircode")
    private Household household;
}