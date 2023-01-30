package model;

public class ConcreteReserveRoom implements Command {

    private Guest guest;
    private Session session;

    ConcreteReserveRoom(Guest guest, Session session) {
        this.guest = guest;
        this.session = session;
    }

    //method to execute the command
    @Override
    public void execute() {
        guest.reserveRoom(session);        
    }
    
}
