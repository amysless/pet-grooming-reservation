package com.petgroomingreservation.model.services.customerservice;

import com.petgroomingreservation.model.domain.Composite;
import com.petgroomingreservation.model.domain.Customer;
import com.petgroomingreservation.model.domain.Reservation;
import com.petgroomingreservation.model.services.exception.CustomerException;
import com.petgroomingreservation.model.services.exception.InputDataException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CustomerServiceImpl implements ICustomerService {

    private final List<Customer> customers = new ArrayList<>();

    public boolean createCustomer(Composite composite) throws CustomerException {
        System.out.println("Entering method CustomerServiceImpl::createCustomer");
        Customer customer = composite.getCustomer();
        try {
            System.out.println("Entering method CustomerServiceImpl::createCustomer");
            customer.validate();
            customers.add(customer);
            return true;
        } catch (Exception  e) {
            System.out.println("Failed to create customer: " + e.getMessage());
            throw new CustomerException("Failed to create customer: " + e.getMessage());
        }
    }

    public boolean getCustomerById(Composite composite) throws CustomerException {
        System.out.println("Entering method CustomerServiceImpl::getCustomerById");
        Customer customer = composite.getCustomer();
        try {
            System.out.println("Entering method CustomerServiceImpl::getCustomerById");

            Optional<Customer> existingCustomer = customers.stream()
                    .filter(a -> Objects.equals(a.getCustomerId(), customer.getCustomerId()))
                    .findFirst();
            if (existingCustomer.isPresent()) {
                return true;
            }
//            return customers.stream()
//                    .filter(p -> Objects.equals(customer.getCustomerId(), p.getCustomerId()))
//                    .findFirst()
//                    .orElse(null);
        } catch (Exception e) {
            throw new CustomerException("Failed to retrieve customer: " + e.getMessage());
        }
        return false;
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

    @Override
    public boolean deleteCustomer(Composite composite) throws CustomerException {
        return false;
    }

//    public boolean deleteCustomer(long customerId) throws CustomerException {
//        System.out.println("Entering method CustomerServiceImpl::deleteCustomer");
//
//        Customer id = this.getCustomerById(customerId);
//        if (id == null) {
//            throw new CustomerException("Unable to delete customer  " + customerId + " doesn't exist in the system!");
//        } else {
//            return true;
//        }
//    }
}

