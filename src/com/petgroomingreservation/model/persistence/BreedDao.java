package com.petgroomingreservation.model.persistence;

import com.petgroomingreservation.model.domain.Breed;
import com.petgroomingreservation.model.domain.Customer;
import com.petgroomingreservation.model.domain.GroomingService;

import java.sql.*;
import java.util.ArrayList;

/**
 * Description: This class acts as a Data Access Object interface between
 *          the LodgeReservationApplication and its underlying MySQL database.
 *          It provides read/write/update functions.
 *
 */
public class BreedDao implements Dao<Breed> {

    private ArrayList<Breed> breeds;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public BreedDao() {
        this.breeds = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(
                    //todo fix
                    "jdbc:mysql://localhost:3306/petgrooming",
                    "pets",
                    "grooming");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select breed from breeds");
        } catch (SQLException e) {
            System.err.println("From BreedDao constructor: " + e);
        }
    }

    public ArrayList<Breed> getAllBreeds() {
        Breed breed;
        try {
            while (resultSet.next()) {
                //todo fix query
                breed = new Breed(resultSet.getString("breed"));
                breeds.add(breed);
            }
        } catch (SQLException e) {

            System.err.println("From Breed.getAll()" + e);
        }
        return breeds;
    }


    @Override
    public ArrayList<Customer> getAllCustomers() {
        return null;
    }

    @Override
    public ArrayList<GroomingService> getAllGroomingServices() {
        return null;
    }

    @Override
    public boolean add(Breed item) {
        return false;
    }

//    @Override
//    public boolean add(Breed breed) {
//        boolean success = false;
//
//        try {
//            statement = connection.createStatement();
//            statement.execute("insert into petgrooming.customers (customerid, lastname, firstname, emailaddress, password,homephone,mobilephone,address, optinnotifications, pets) " +
//                    "values ('" + customer.getCustomerId() + "', '" + customer.getLastName() +"', '" +  customer.getFirstName() +"', '" +  customer.getEmailAddress() + "', '" + customer.getPassword() + "', '" + customer.getHomePhone() + "', '" + customer.getMobilePhone() + "', '" + "XXXX" + "', '" + 1 + "', '" + "XXX" + "');");
//            success = true;
//        } catch (SQLException e) {
//            System.err.println("From BreedDao.add() " + e);
//        }
//        return success;
//    }

    @Override
    public boolean update(Breed breed) {
        return false;
    }

    @Override
    public boolean delete(Breed breed) {
        return false;
    }
}