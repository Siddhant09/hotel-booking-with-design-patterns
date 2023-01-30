package model;

public interface Admin {
    
    //method to display menu
    int display(Session session);

    //method to browse rooms
    void browseRooms();

    //method to view users
    void viewUsers(String type);

    //method to delete user
    void deleteUser(String type);

    //method to delete room
    void deleteRoom();

    //method to add room
    void addRoom(String operation);

    //method to add user
    void addUser(String type);
    
}
