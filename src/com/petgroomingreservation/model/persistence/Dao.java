package com.petgroomingreservation.model.persistence;

import com.petgroomingreservation.model.domain.Breed;
import com.petgroomingreservation.model.domain.Customer;
import com.petgroomingreservation.model.domain.GroomingService;

import java.util.ArrayList;

/**
 * This interface specifies CRUD operations upon an object of type T. It uses a
 * Data Access Object design pattern.
 *
 * @param <T>   a generic object type
 */
public interface Dao<T> {
    ArrayList<Customer> getAllCustomers();
    ArrayList<GroomingService> getAllGroomingServices();

    ArrayList<Breed> getAllBreeds();

    boolean add(T item);
    boolean update(T item);
    boolean delete(T item);
}