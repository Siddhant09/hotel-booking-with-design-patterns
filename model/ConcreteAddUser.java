package model;

public class ConcreteAddUser implements Command {

    private Admin admin;
    private String type;

    ConcreteAddUser(Admin admin, String type) {
        this.admin = admin;
        this.type = type;
    }

    //method to execute the command
    @Override
    public void execute() {
        admin.addUser(type);        
    }
    
}
