package model;

public class AdminFactory extends AbstractFactory {

    //method to get concrete admin 
    @Override
    Admin getAdmin(String admin) {
        if(admin == null)
            return null;

        if(admin.equalsIgnoreCase("Admin"))
            return new ConcreteAdmin();
            
        return null;
    }

    @Override
    Guest getUser(String user) {
        return null;
    }
    
}
