package model;

public class ConcreteCancelBooking implements Command {

    private Guest guest;
    private Session session;

    ConcreteCancelBooking(Guest guest, Session session) {
        this.guest = guest;
        this.session = session;
    }

    //method to execute the command
    @Override
    public void execute() {
        guest.cancelReservation(session);        
    }
    
}
