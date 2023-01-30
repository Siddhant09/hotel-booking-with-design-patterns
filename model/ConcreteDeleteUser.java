package model;

public class ConcreteDeleteUser implements Command {

    private Admin admin;
    private String type;

    ConcreteDeleteUser(Admin admin, String type) {
        this.admin = admin;
        this.type = type;
    }

    //method to execute the command
    @Override
    public void execute() {
        admin.deleteUser(type);        
    }
    
}
