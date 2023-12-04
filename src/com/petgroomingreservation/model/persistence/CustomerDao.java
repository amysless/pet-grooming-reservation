package com.petgroomingreservation.model.persistence;

import com.petgroomingreservation.model.domain.Customer;
import java.sql.*;
import java.util.ArrayList;

/**
 * Description: This class acts as a Data Access Object interface between
 *          the LodgeReservationApplication and its underlying MySQL database.
 *          It provides read/write/update functions.
 *
 */
public class CustomerDao implements Dao<Customer> {

    private ArrayList<Customer> customers;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public CustomerDao() {
        this.customers = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(
                    //todo fix
                    "jdbc:mysql://localhost:3306/petgrooming",
                    "pets",
                    "grooming");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from customers");
        } catch (SQLException e) {
            System.err.println("From CustomerDao constructor: " + e);
        }
    }

    @Override
    public ArrayList<Customer> getAll() {
        Customer customer;
        try {
            while (resultSet.next()) {
                //todo fix query
                customer = new Customer(resultSet.getLong("customerid"),
                        resultSet.getString("lastname"),
                        resultSet.getString("firstname"),
                        resultSet.getString("emailaddress"),
                        resultSet.getString("password"),
                        resultSet.getString("homephone"),
                        resultSet.getString("mobilephone"),
                        resultSet.getString("address"),
                        resultSet.getString("optinnotifications"),
                        resultSet.getString("pets"));
                customers.add(customer);
            }
        } catch (SQLException e) {

            System.err.println("From ReservationDao.getAll()" + e);
        }
        return customers;
    }

    @Override
    public boolean add(Customer customer) {
        boolean success = false;

        try {
            statement = connection.createStatement();
            statement.execute("insert into petgrooming.customers (customerid, lastname, firstname, emailaddress, password,homephone,mobilephone,address, optinnotifications, pets) " +
                    "values ('" + customer.getCustomerId() + "', '" + customer.getLastName() +"', '" +  customer.getFirstName() +"', '" +  customer.getEmailAddress() + "', '" + customer.getPassword() + "', '" + customer.getHomePhone() + "', '" + customer.getMobilePhone() + "', '" + "XXXX" + "', '" + 1 + "', '" + "XXX" + "');");
            success = true;
        } catch (SQLException e) {
            System.err.println("From CustomerDao.add() " + e);
        }
        return success;
    }

    @Override
    public boolean update(Customer customer) {
        return false;
    }

    @Override
    public boolean delete(Customer customer) {
        return false;
    }
}