package com.petgroomingreservation.model.services.factory;

import com.petgroomingreservation.model.services.addressservice.AddressServiceImpl;
import com.petgroomingreservation.model.services.addressservice.IAddressService;
import com.petgroomingreservation.model.services.loginservice.ILoginService;
import com.petgroomingreservation.model.services.loginservice.LoginServiceImpl;

/**
 * Simplistic implementation of a Service Factory.
 */
public class ServiceFactory {

    public ILoginService getLoginService() {
       return new LoginServiceImpl();

    }

   public IAddressService getAddressService()
   {
      return new AddressServiceImpl();
   }
}