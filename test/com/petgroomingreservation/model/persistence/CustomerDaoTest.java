package com.petgroomingreservation.model.persistence;

import com.petgroomingreservation.model.domain.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.transform.Result;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDaoTest {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private ArrayList<Customer> records;
    private CustomerDao customerDao;
    private Customer customer;
    private GroomingService groomingService;
    private Breed breed;
    private Pet pet;
    private Address address;

    @BeforeEach
    void setUp() {
        Customer customer = new Customer();
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/petgrooming",
                    "pets",
                    "grooming");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from customers");
            records = new ArrayList<>();
            customerDao = new CustomerDao();

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    @AfterEach
    void tearDown() {
        try {
            connection.close();
            assert(connection.isClosed());
            System.out.println("tear down complete, connection closed");
        } catch (SQLException e) {
            System.err.println("Error closing connection " + e);
            fail("SQLException");
        }
    }

    @Test
    void testGetAll() {
        int size = 0;
        int numResults = 0;
        try {
            records = customerDao.getAll();
            while(resultSet.next()) {
                records.add(new Customer());
            }
            statement.executeQuery("select count(*) as count from customers");
            System.out.println(numResults);
            size = records.size();
            assert(size != 0);
            System.out.println("testGetAll PASSED");

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @Test
    void testAdd() {
        List<GroomingService> groomingServiceList = new ArrayList<>();
        groomingService = new GroomingService("Bath", 30);
        groomingServiceList.add(groomingService);
        groomingService = new GroomingService("Nails", 10);
        groomingServiceList.add(groomingService);
        breed = new Breed("Dalmatian", groomingServiceList);
        List<Pet> petList = new ArrayList<>();
        pet = new Pet("Poppy", 54.5, LocalDate.of(2021, 4, 1), breed);
        petList.add(pet);

        // create an address and a customer
        address = new Address(123, "4 Linden Street", "Boston", "MA", "01234");
        customer = new Customer(111L, "Sless", "Amy", "asless@regis.edu", "dkjfglg", "7819855231", "7819855231", address, true, petList);

        assert(customerDao.add(customer));
        System.out.println("testAdd PASSED");
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
} 