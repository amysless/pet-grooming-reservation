package com.petgroomingreservation.model.domain;

import java.util.List;
import java.util.Objects;

/*
  Breed domain to contain relevant breed information
 */
public class Breed {

    private String breed;

    private List<GroomingServices> availableServices;

    //default/no args constructor
    public Breed() {
    }

    //parameterized constuctor
    public Breed(String breed, List<GroomingServices> availableServices) {
        this.breed = breed;
        this.availableServices = availableServices;
    }


    //setters and getters
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public List<GroomingServices> getAvailableServices() {
        return availableServices;
    }

    public void setAvailableServices(List<GroomingServices> availableServices) {
        this.availableServices = availableServices;
    }

    //toString method can be used for logging
    @Override
    public String toString() {
        return "Breed{" +
                "breed='" + breed + '\'' +
                ", availableServices=" + availableServices +
                '}';
    }

    //equals method to validate objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Breed breed1)) return false;
        return Objects.equals(breed, breed1.breed) && Objects.equals(availableServices, breed1.availableServices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(breed, availableServices);
    }
}
