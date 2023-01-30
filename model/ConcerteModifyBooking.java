package model;

public class ConcerteModifyBooking implements Command {

    private Guest guest;
    private Session session;

    ConcerteModifyBooking(Guest guest, Session session) {
        this.guest = guest;
        this.session = session;
    }

    //method to execute the command
    @Override
    public void execute() { 
        guest.modifyReservation(session);        
    }
    
}
