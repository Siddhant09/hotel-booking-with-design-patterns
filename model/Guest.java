
package model;

public interface Guest {

    //method to dsplay menu
    int display(Session session);

    //method to browse rooms
    void browseRooms();

    //method to book a room
    void reserveRoom(Session session);

    //method to modify a reservation
    void modifyReservation(Session session);

    //method to cancel a reservation
    void cancelReservation(Session session);
    
}