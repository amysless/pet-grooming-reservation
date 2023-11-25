package com.petgroomingreservation.model.services.factory;

import com.petgroomingreservation.model.business.exception.ServiceLoadException;
import com.petgroomingreservation.model.services.IService;
import com.petgroomingreservation.model.services.addressservice.AddressServiceImpl;
import com.petgroomingreservation.model.services.addressservice.IAddressService;
import com.petgroomingreservation.model.services.customerservice.CustomerServiceImpl;
import com.petgroomingreservation.model.services.customerservice.ICustomerService;
import com.petgroomingreservation.model.services.reservationservice.IReservationService;
import com.petgroomingreservation.model.services.reservationservice.ReservationServiceImpl;


public class ServiceFactory {

    public ServiceFactory() {

    }

    private static ServiceFactory serviceFactory = new ServiceFactory();

    public static ServiceFactory getInstance() {
        return serviceFactory;
    }

    public IService getService(String serviceName) throws ServiceLoadException {
        try {
            // Class is a parametrizable class. By writing Class<?>, we're declaring a Class object
            // which can be of any type (? is a wildcard).
            // Reference about Generics and Wildcards:http://docs.oracle.com/javase/tutorial/java/generics/wildcards.html
            Class<?> c = Class.forName(getImplName(serviceName));
            return (IService) c.newInstance();
        } catch (Exception excp) {
            serviceName = serviceName + " not loaded";
            throw new ServiceLoadException(serviceName, excp);
        }
    }

    private String getImplName(String serviceName) throws Exception {

        java.util.Properties props = new java.util.Properties();

        String propertyFileLocation = System.getProperty("prop_location");

        System.out.println("Property File Location passed : "
                + propertyFileLocation);
        java.io.FileInputStream fis = new java.io.FileInputStream(
                propertyFileLocation);

        props.load(fis);
        fis.close();
        return props.getProperty(serviceName);
    }
    public IAddressService getAddressService() { return new AddressServiceImpl(); }

    public ICustomerService getCustomerService() {
        return new CustomerServiceImpl();
    }

    public IReservationService getReservationService() {
        return new ReservationServiceImpl();
    }


}