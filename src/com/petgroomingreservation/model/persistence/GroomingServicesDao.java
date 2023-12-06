package com.petgroomingreservation.model.persistence;

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
public class GroomingServicesDao implements Dao<GroomingService> {

    private ArrayList<GroomingService> groomingServices;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public GroomingServicesDao() {
        this.groomingServices = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(
                    //todo fix
                    "jdbc:mysql://localhost:3306/petgrooming",
                    "pets",
                    "grooming");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from grooming_services");
        } catch (SQLException e) {
            System.err.println("From GroomingServicesDao constructor: " + e);
        }
    }

    @Override
    public ArrayList<Customer> getAllCustomers() {
        return null;
    }

    public ArrayList<GroomingService> getAllGroomingServices() {
        GroomingService groomingService;
        try {
            while (resultSet.next()) {
                //todo fix query
                groomingService = new GroomingService(resultSet.getInt("grooming_service_id"),
                        resultSet.getString("service_name"),
                        resultSet.getInt("minutes"));
                groomingServices.add(groomingService);
            }
        } catch (SQLException e) {

            System.err.println("From GroomingServicesDao.getAll()" + e);
        }
        return groomingServices;
    }

    @Override
    public boolean add(GroomingService groomingService) {
        boolean success = false;

        try {
            statement = connection.createStatement();
            statement.execute("insert into petgrooming.grooming_services (grooming_service_id, service_name, minutes) " +
                    "values ('" + groomingService.getServiceId() + "', '" + groomingService.getServiceName() +"', '" +  groomingService.getMinutes() + "');");
            success = true;
        } catch (SQLException e) {
            System.err.println("From GroomingServicesDao.add() " + e);
        }
        return success;
    }

    @Override
    public boolean update(GroomingService groomingService) {
        return false;
    }

    @Override
    public boolean delete(GroomingService groomingService) {
        return false;
    }
}