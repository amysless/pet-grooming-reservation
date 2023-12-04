package com.petgroomingreservation.model.persistence;

import com.petgroomingreservation.model.domain.Customer;

import java.util.ArrayList;

/**
 * This interface specifies CRUD operations upon an object of type T. It uses a
 * Data Access Object design pattern.
 *
 * @param <T>   a generic object type
 */
public interface Dao<T> {
    ArrayList<Customer> getAll();
    boolean add(T item);
    boolean update(T item);
    boolean delete(T item);
}