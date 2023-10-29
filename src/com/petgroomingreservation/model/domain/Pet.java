package com.petgroomingreservation.model.domain;

import java.time.LocalDate;
import java.util.Objects;

/*
  Pet domain to represent pet related information
 */
public class Pet {
    private String name;

    private double weight;

    private LocalDate dateOfBirth;

    private Breed breed;

    //no args constuctor
    public Pet() {
    }

    //all args constructor
    public Pet(String name, double weight, LocalDate dateOfBirth, Breed breed) {
        this.name = name;
        this.weight = weight;
        this.dateOfBirth = dateOfBirth;
        this.breed = breed;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    //toString method can be used for logging
    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", dateOfBirth=" + dateOfBirth +
                ", breed=" + breed +
                '}';
    }

    public boolean validate() {
        if (name == null)
            return false;
        if (weight == 0)
            return false;
        if (dateOfBirth == null)
            return false;
        if (breed == null)
            return false;

        return true;
    }
    //equals method to validate objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet pet)) return false;
        return Double.compare(weight, pet.weight) == 0 && Objects.equals(name, pet.name) && Objects.equals(dateOfBirth, pet.dateOfBirth) && Objects.equals(breed, pet.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, dateOfBirth, breed);
    }
}
