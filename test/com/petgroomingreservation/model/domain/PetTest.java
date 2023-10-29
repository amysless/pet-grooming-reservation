package com.petgroomingreservation.model.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {
    private Pet pet1, pet2;
    private Breed breed;


    @BeforeEach
    public void setUp() throws Exception {
        breed = new Breed("dalmatian");
        pet1 = new Pet("Poppy", 54.5, LocalDate.of(2021, 04, 01), breed);
        pet2 = new Pet("Poppy", 54.5, LocalDate.of(2021, 04, 01), breed);

    }

    @Test
    public void testValidatePet() {
        System.out.println("starting testValidatePet()");
        // pet1.validate should assert to True since all variables
        // being passed to create a new Pet are all valid.
        assertTrue(pet1.validate(), "pet validates");
        System.out.println("testValidatePet PASSED");
    }

    @Test
    public final void testEqualsPet() {
        System.out.println("starting testEqualsPet()");
        // this should assert to true since the contents of
        // pet1 and pet2 class variables are identical.
        assertTrue(pet1.equals(pet2), "pet1 equals pet2");
        System.out.println("testEqualsCustomer PASSED");
    }
}