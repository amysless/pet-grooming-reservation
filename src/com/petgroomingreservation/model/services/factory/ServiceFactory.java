package com.petgroomingreservation.model.services.factory;

import com.petgroomingreservation.model.business.exception.ServiceLoadException;
import com.petgroomingreservation.model.domain.Composite;
import com.petgroomingreservation.model.domain.Reservation;
import com.petgroomingreservation.model.services.IService;
import com.petgroomingreservation.model.services.addressservice.AddressServiceImpl;
import com.petgroomingreservation.model.services.addressservice.IAddressService;
import com.petgroomingreservation.model.services.customerservice.CustomerServiceImpl;
import com.petgroomingreservation.model.services.customerservice.ICustomerService;
import com.petgroomingreservation.model.services.exception.CustomerException;
import com.petgroomingreservation.model.services.exception.ReservationException;
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
        System.out.println("I'm here get getService" );

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

        System.out.println("I'm here get implname" );

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
        return new CustomerServiceImpl() {
            @Override
            public boolean deleteCustomer(Composite composite) throws CustomerException {
                return false;
            }
        };
    }

    public IReservationService getReservationService() {
        return new ReservationServiceImpl() {
            @Override
            public boolean createReservation(Composite composite) throws ReservationException {
                return false;
            }
        };
    }


}