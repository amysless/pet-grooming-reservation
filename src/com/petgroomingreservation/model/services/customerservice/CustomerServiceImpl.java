package com.petgroomingreservation.model.services.customerservice;

import com.petgroomingreservation.model.domain.Customer;
import com.petgroomingreservation.model.services.exception.CustomerException;
import com.petgroomingreservation.model.services.exception.InputDataException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CustomerServiceImpl implements ICustomerService {

    private final List<Customer> customers = new ArrayList<>();

    public Customer createCustomer(Customer customer) throws InputDataException {
        System.out.println("Entering method CustomerServiceImpl::createCustomer");
        try {
            System.out.println("Entering method CustomerServiceImpl::createCustomer");
            customer.validate();
            customers.add(customer);
            return customer;
        } catch (Exception  e) {
            System.out.println("Failed to create customer: " + e.getMessage());
            throw new InputDataException("Failed to create customer: " + e.getMessage());
        }
    }

    public Customer getCustomerById(long customerId) throws InputDataException {

        try {
            System.out.println("Entering method CustomerServiceImpl::getCustomerById");

            return customers.stream()
                    .filter(p -> Objects.equals(customerId, p.getCustomerId()))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            throw new InputDataException("Failed to retrieve customer: " + e.getMessage());
        }
    }

    public Customer updateCustomer(Customer customer) throws CustomerException,InputDataException {
        System.out.println("Entering method CustomerServiceImpl::updateCustomer");
        customer.validate();

        Optional<Customer> existingCustomer = customers.stream()
                .filter(a -> Objects.equals(a.getCustomerId(), customer.getCustomerId()))
                .findFirst();

        if (existingCustomer.isPresent()) {
            Customer toUpdate = existingCustomer.get();
            toUpdate.setLastName(customer.getLastName());
            toUpdate.setFirstName(customer.getFirstName());
            toUpdate.setEmailAddress(customer.getEmailAddress());
            toUpdate.setPassword(customer.getPassword());
            toUpdate.setHomePhone(customer.getHomePhone());
            toUpdate.setMobilePhone(customer.getMobilePhone());
            toUpdate.setAddress(customer.getAddress());
            toUpdate.setOptInNotifications(customer.getOptInNotifications());
            toUpdate.setPets(customer.getPets());
            System.out.println("Customer updated for id: " + toUpdate.getCustomerId());
            return toUpdate;
        } else {
            throw new CustomerException("No customer found for id " + customer.getCustomerId());
        }
    }

    public boolean deleteCustomer(long customerId) throws CustomerException, InputDataException {
        System.out.println("Entering method CustomerServiceImpl::deleteCustomer");

        Customer id = this.getCustomerById(customerId);
        if (id == null) {
            throw new CustomerException("Unable to delete customer  " + customerId + " doesn't exist in the system!");
        } else {
            return true;
        }
    }
}

