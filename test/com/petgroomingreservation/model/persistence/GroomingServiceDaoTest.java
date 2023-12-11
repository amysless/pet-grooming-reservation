package com.petgroomingreservation.model.persistence;

import com.petgroomingreservation.model.domain.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

class GroomingServiceDaoTest {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private ArrayList<GroomingService> records;
    private GroomingServicesDao groomingServicesDao;
    private Customer customer;
    private GroomingService groomingService;
    private Breed breed;
    private Pet pet;
    private Address address;

    @BeforeEach
    void setUp() {
        GroomingService groomingService = new GroomingService();
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/petgrooming",
                    "pets",
                    "grooming");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from grooming_services");
            records = new ArrayList<>();
            groomingServicesDao = new GroomingServicesDao();

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
            records = groomingServicesDao.getAllGroomingServices();
            while(resultSet.next()) {
                records.add(new GroomingService());
            }
            statement.executeQuery("select count(*) as count from grooming_services");
            System.out.println(numResults);
            size = records.size();
            assert(size != 0);
            System.out.println("testGetAll PASSED");

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    //todo fix

//    @Test
//    void testAdd() {
//        List<GroomingService> groomingServiceList = new ArrayList<>();
//        groomingService = new GroomingService(10,"Bath", 30);
//        groomingServiceList.add(groomingService);
//        groomingService = new GroomingService(9, "Nails", 10);
//        groomingServiceList.add(groomingService);
//
//        assert(groomingServicesDao.add(groomingService));
//        System.out.println("testAdd PASSED");
//    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}