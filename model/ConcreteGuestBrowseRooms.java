package model;

public class ConcreteGuestBrowseRooms implements Command {

    private Guest guest;

    ConcreteGuestBrowseRooms(Guest guest) {
        this.guest = guest;
    }

    //method to execute the command
    @Override
    public void execute() {
        guest.browseRooms();        
    }
    
}
