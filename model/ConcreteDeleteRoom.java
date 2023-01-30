package model;

public class ConcreteDeleteRoom implements Command {

    private Admin admin;

    ConcreteDeleteRoom(Admin admin) {
        this.admin = admin;
    }

    //method to execute the command
    @Override
    public void execute() {
        admin.deleteRoom();        
    }
    
}
