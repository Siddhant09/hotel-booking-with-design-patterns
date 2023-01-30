package model;

public abstract class AbstractFactory {

    //to admin admin factory
    abstract Admin getAdmin(String admin);

    //to get guest factory
    abstract Guest getUser(String user);
    
}
