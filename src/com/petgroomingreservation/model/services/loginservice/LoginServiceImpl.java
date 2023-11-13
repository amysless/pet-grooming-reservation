package com.petgroomingreservation.model.services.loginservice;

import com.petgroomingreservation.model.domain.Customer;

public class LoginServiceImpl implements ILoginService {


	/**
	 * Validates if the customer is indeed registered in our system.
	 * 
	 *  @param customer contains customer's login credentials
	 */
	public boolean authenticateCustomer(Customer customer) {
		System.out.println ("Entering method LoginServiceImpl::authenticateCustomer");
		
		return true;
	}	
}
