package model;

public class ConcreteBrowseRooms implements Command {

    private Admin admin;

    ConcreteBrowseRooms(Admin admin) {
        this.admin = admin;
    }

    //method to execute the command
    @Override
    public void execute() {
        admin.browseRooms();        
    }
    
}
