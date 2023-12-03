package com.petgroomingreservation.model.business.manager;

import com.petgroomingreservation.model.business.exception.ServiceLoadException;
import com.petgroomingreservation.model.domain.Composite;
import com.petgroomingreservation.model.domain.Reservation;
import com.petgroomingreservation.model.services.exception.AddressException;
import com.petgroomingreservation.model.services.exception.CustomerException;
import com.petgroomingreservation.model.services.exception.InputDataException;
import com.petgroomingreservation.model.services.exception.LoginException;
import com.petgroomingreservation.model.services.exception.ReservationException;
import com.petgroomingreservation.model.services.factory.ServiceFactory;
import com.petgroomingreservation.model.services.addressservice.IAddressService;
import com.petgroomingreservation.model.services.customerservice.ICustomerService;
import com.petgroomingreservation.model.services.loginservice.ILoginService;
import com.petgroomingreservation.model.services.reservationservice.IReservationService;


public class ReservationManager extends ManagerSuperType {

    private static ReservationManager myInstance;


    private ReservationManager() {

    }

    /**
     * Ensure that only one ReservationManager gets created.
     *
     * @return reservationManager instance
     */
    public static synchronized ReservationManager getInstance() {
        if (myInstance == null) {
            myInstance = new ReservationManager();
        }
        return myInstance;
    }

    /**
     * Facade design pattern, allow all clients of the ReservationManager class
     * to perform certain named actions.
     *
     * @param commandString holds the name of the action to be performed
     * @param composite     holds application-specific domain state
     * @return action       true if the action was successful, false otherwise
     */
    public boolean performAction(String commandString, Composite composite) {
        boolean action = false;
        switch (commandString) {
            case "CREATE_ADDRESS" -> action = createAddress(composite);
            case "CREATE_CUSTOMER" -> action = createCustomer(composite);
            case "CHECK_CUSTOMER" -> action = checkCustomer(composite);
            case "CREATE_RESERVATION" -> action = createReservation(composite);
            case "DELETE_RESERVATION" -> action = deleteReservation(composite);
            default ->
                    System.out.println("NO ACTION PERFORMED... ReservationManager:: commandString: " + commandString);
        }
        return action;
    }

    private boolean createReservation(Composite composite) {
        System.out.println(composite + " composite");

        boolean isCreated = false;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        IReservationService iReservationService;

        try {
            iReservationService = (IReservationService) serviceFactory.getService(IReservationService.NAME);
            System.out.println(iReservationService);
            isCreated = iReservationService.createReservation(composite);
        } catch(ServiceLoadException serviceLoadException) {
            System.err.println("ServiceLoadException from ReservationManager: " + serviceLoadException.getMessage());
        } catch (ReservationException reservationException) {
            System.out.println(reservationException.getMessage());
        }
        return isCreated;
    }


    /**
     * Book a reservation.
     *
     * @param composite the application-specific domain state
     * @return true if the reservation was successful, false otherwise
     * @see "LodgeReservationManager.performAction(String, Composite)"
     */
    private boolean createCustomer(Composite composite) {

        boolean isCustomerCreated = false;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ICustomerService iCustomerService;

        // Propagate errors up the call stack, to be caught here in the Business Layer.
        // https://docs.oracle.com/javase/tutorial/essential/exceptions/advantages.html
        try {
            System.out.println("createCustomer");
            iCustomerService = (ICustomerService) serviceFactory.getService(ICustomerService.NAME);
            System.out.println("getService");
            isCustomerCreated = iCustomerService.createCustomer(composite);
            System.out.println(isCustomerCreated);

        } catch (ServiceLoadException serviceLoadException) {
            System.err.println("ServiceLoadException from ReservationManager: " + serviceLoadException.getMessage());
        } catch (CustomerException customerException) {
            System.err.println("CustomerException from ReservationManager: " + customerException.getMessage());
        }
        return isCustomerCreated;
    }

    private boolean deleteReservation(Composite composite) {
        boolean isDeleted = false;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        IReservationService iReservationService;

        try {
            iReservationService = (IReservationService) serviceFactory.getService(IReservationService.NAME);
            isDeleted = iReservationService.deleteReservation(composite);
        } catch (ServiceLoadException serviceLoadException) {
            System.err.println("ServiceLoadException from ReservationManager: " + serviceLoadException.getMessage());
        } catch (ReservationException reservationException) {
            System.err.println("ReservationException from ReservationManager: " + reservationException.getMessage());
        }
        return isDeleted;
    }

    /**
     * Create a customer address
     *
     * @param composite the application-specific domain state
     * @return true if the reservation was successful, false otherwise
     * @see "LodgeReservationManager.performAction(String, Composite)"
     */
    private boolean createAddress(Composite composite) {
        boolean isAddressCreated = false;
        System.out.println(composite + " composite");

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        IAddressService iAddressService;

        try {
            iAddressService = (IAddressService) serviceFactory.getService(IAddressService.NAME);
            isAddressCreated = iAddressService.createAddress(composite);

        } catch (ServiceLoadException serviceLoadException) {
            System.err.println("ERROR: ReservationManager:: failed to load Address Service " + serviceLoadException.getMessage());

        } catch (AddressException e) {
            System.err.println("ERROR: ReservationManager:: Address Services failed " + e.getMessage());
        }
        return isAddressCreated;
    }


    /**
     * Check Customer.
     *
     * @param composite the application-specific domain state
     * @return true if the reservation was successful, false otherwise
     * @see "LodgeReservationManager.performAction(String, Composite)"
     */
    private boolean checkCustomer(Composite composite) {
        boolean isValidCustomer = false;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ICustomerService iCustomerService;

        try {
            iCustomerService = (ICustomerService) serviceFactory.getService(ICustomerService.NAME);
            isValidCustomer = iCustomerService.getCustomerById(composite);

        } catch (ServiceLoadException serviceLoadException) {
            System.err.println("ERROR: ReservationManager:: failed to load Customer Service " + serviceLoadException.getMessage());
        }
        catch (CustomerException customerException) {
            System.err.println("ERROR: ReservationManager:: failed to load Customer Service " + customerException.getMessage());
        }
        return isValidCustomer;
    }


}