package model;

public class GuestFactory extends AbstractFactory {

    @Override
    Admin getAdmin(String admin) {
        return null;
    }

    //method to get concrete guest
    @Override
    Guest getUser(String user) {
        if(user == null)
            return null;

        if(user.equalsIgnoreCase("Guest"))
            return new ConcreteGuest();
        return null;
    }
    
}
