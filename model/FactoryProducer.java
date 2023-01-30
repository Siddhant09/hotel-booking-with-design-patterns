package model;

public class FactoryProducer {

    //method to fetch appropriate factory
    public static AbstractFactory getFactory(String option) {
        
        if (option.equalsIgnoreCase("Admin")) {
            //returning admin factory of user is admin
            return new AdminFactory();
        } else if (option.equalsIgnoreCase("Guest")) {
            //returning admin factory of user is admin
            return new GuestFactory();
        }

        return null;
    }
}
