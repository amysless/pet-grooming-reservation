package com.petgroomingreservation.model.services.loginservice;

import com.petgroomingreservation.model.domain.Composite;
import com.petgroomingreservation.model.domain.Customer;
import com.petgroomingreservation.model.services.exception.LoginException;

public class LoginServiceImpl implements ILoginService {
	/**
	 * Authenticate customer into our application
	 * @param composite
	 * 							contains customer information to be authenticated
	 * @throws LoginException
	 * 							If the Customer object in the composite is null or
	 *   				        If the file that contains the customer information is not found or
	 *   					    If an unexpected exception is encountered while accessing the file.
	 * @return boolean
	 * 					true - if authenticated
	 * 				    false - if failed to authenticate
	 * */
	public boolean authenticateCustomer(Composite composite) throws LoginException {
		System.out.println ("Entering method LoginServiceImpl::authenticateCustomer");

		return true;
	}

	/**
	 * Authenticate an admin user into our application
	 * @param customer
	 * @throws LoginException
	 * @return boolean
	 * 					true - if authenticated
	 * 				    false - if failed to authenticate
	 */
	public boolean authenticateAdmin(Customer customer) throws LoginException {
		System.out.println ("Entering method LoginServiceImpl::authenticateAdmin");

		return true;
	}
}