package com.petgroomingreservation.model.services.loginservice;

import com.petgroomingreservation.model.domain.Composite;

import com.petgroomingreservation.model.domain.Customer;
import com.petgroomingreservation.model.services.IService;
import com.petgroomingreservation.model.services.exception.LoginException;

public interface ILoginService extends IService {
    public final String NAME = "ILoginService";

    /**
     * Authenticate customer into our application
     *
     * @param composite contains customer information to be authenticated
     * @return boolean
     * true - if authenticated
     * false - if failed to authenticate
     * @throws LoginException If the Customer object in the composite is null or
     *                        If the file that contains the customer information is not found or
     *                        If an unexpected exception is encountered while accessing the file.
     */
    public boolean authenticateCustomer(Composite composite) throws LoginException;

    public boolean authenticateAdmin(Customer customer) throws LoginException;
}