package com.petgroomingreservation.model.business.manager;

import com.petgroomingreservation.model.business.exception.PropertyFileNotFoundException;
import com.petgroomingreservation.model.domain.Composite;
import com.petgroomingreservation.model.services.manager.PropertyManager;

public abstract class ManagerSuperType {
    static
    {
        try
        {
            ManagerSuperType.loadProperties();
        }
        catch (PropertyFileNotFoundException propertyFileNotFoundException)
        {
            System.out.println ("Application Properties failed to be loaded - Application exiting...");
            System.exit(1);
        }
    }

    public abstract boolean performAction(String commandString, Composite composite);

    public static void loadProperties () throws PropertyFileNotFoundException
    {

//        String propertyFileLocation = System.getProperty("prop_location");
        String propertyFileLocation = "/Users/ajsless/Documents/GitHub/pet-grooming-reservation/config/application.properties";

        if (propertyFileLocation != null)
        {
            // Now that we have the property file location, lets have the
            // PropertyManager class load it up
            PropertyManager.loadProperties(propertyFileLocation);
        }
        else
        {
            System.out.println("Property file location not set. Passed in value is: " + propertyFileLocation + ".");
            throw new PropertyFileNotFoundException ("Property file location not set", null);
        }


    } //end loadProperties
}

