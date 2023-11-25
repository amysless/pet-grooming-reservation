package com.petgroomingreservation.model;

import com.petgroomingreservation.model.services.addressservice.AddressServiceImplTest;
import com.petgroomingreservation.model.services.customerservice.CustomerServiceImplTest;
import com.petgroomingreservation.model.services.reservation.service.ReservationServiceImplTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AddressServiceImplTest.class, CustomerServiceImplTest.class, ReservationServiceImplTest.class})
public class AllServicesTests {

}
