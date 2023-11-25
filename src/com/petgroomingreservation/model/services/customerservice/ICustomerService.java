package com.petgroomingreservation.model.services.customerservice;

import com.petgroomingreservation.model.domain.Customer;
import com.petgroomingreservation.model.services.IService;
import com.petgroomingreservation.model.services.exception.CustomerException;
import com.petgroomingreservation.model.services.exception.InputDataException;

public interface ICustomerService extends IService {

    public final String NAME = "ICustomerService";

    Customer createCustomer(Customer customer) throws InputDataException;

    Customer getCustomerById(long customerId) throws InputDataException;

    Customer updateCustomer(Customer customer) throws InputDataException, CustomerException;

    boolean deleteCustomer(long customerId) throws InputDataException, CustomerException;

}
