package com.petgroomingreservation.model.services.customerservice;

import com.petgroomingreservation.model.domain.Composite;
import com.petgroomingreservation.model.domain.Customer;
import com.petgroomingreservation.model.services.IService;
import com.petgroomingreservation.model.services.exception.CustomerException;
import com.petgroomingreservation.model.services.exception.InputDataException;

public interface ICustomerService extends IService {

    public final String NAME = "ICustomerService";

    boolean createCustomer(Composite composite) throws CustomerException;

    boolean getCustomerById(Composite composite) throws CustomerException;

    Customer updateCustomer(Customer customer) throws InputDataException,CustomerException;

    boolean deleteCustomer(Composite composite) throws CustomerException;

}
