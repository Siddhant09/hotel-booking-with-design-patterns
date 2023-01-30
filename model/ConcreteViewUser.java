package model;

public class ConcreteViewUser implements Command {

    private Admin admin;
    private String type;

    ConcreteViewUser(Admin admin, String type) {
        this.admin = admin;
        this.type = type;
    }

    //method to execute the command
    @Override
    public void execute() {
        admin.viewUsers(type);        
    }
    
}
