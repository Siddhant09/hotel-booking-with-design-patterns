package model;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface HotelBooking extends Remote {

    //method for registering an admin
    boolean adminRegister(String userName, String email, String password) throws RemoteException;

    //method for registering a guest
    boolean guestRegister(String userName, String email, String password) throws RemoteException;

    //method for admin login
    boolean adminLogin(String userName, String password) throws RemoteException;

    //method for guest login
    boolean guestLogin(String userName, String password) throws RemoteException;

    //method for processing login
    Session processLogin(String userType, String userName) throws RemoteException;

    //method for browsing rooms
    List<String> browseRooms() throws RemoteException;

    //method for adding a room
    boolean addRoom(String operation, String roomNo, String type, String description, String price, String rating, String noOfBeds,
    String typeOfBed, String isSmokingAllowed, String isAvailable) throws RemoteException;

    //method for deleting a room
    boolean deleteRoom(String roomNo) throws RemoteException;

    //method for viewing users
    List<String> viewUsers(String type) throws RemoteException;

    //method for deleting a user
    boolean deleteUser(String type, String email) throws RemoteException;

    //methods for checking if room is available
    String checkRoomAvailability(String roomNo, int days, boolean isNew) throws RemoteException;

    //method for booking a room
    boolean reserveRoom(String roomNo, String email, int days, String address, String mobileNo, String cardNo) throws RemoteException;

    //method for viewing current reservations
    List<String> viewBookings(String role, String email) throws RemoteException;

    //method for modifying the reservation
    String modifyReservation(String roomNo, String newRoonNo, String email, int days) throws RemoteException;

    //method for calcelling the reservation
    String cancelReservation(String roomNo, String email) throws RemoteException;
}
