package com.petgroomingreservation.model.services.loginservice;

import com.petgroomingreservation.model.domain.Customer;

public interface ILoginService {
	
	public boolean authenticateCustomer(Customer customer);

}
