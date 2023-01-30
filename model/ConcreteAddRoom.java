package model;

public class ConcreteAddRoom implements Command {

    private Admin admin;
    private String operation;

    ConcreteAddRoom(Admin admin, String operation) {
        this.admin = admin;
        this.operation = operation;
    }

    //method to execute the command
    @Override
    public void execute() {
        admin.addRoom(operation);        
    }
    
}
