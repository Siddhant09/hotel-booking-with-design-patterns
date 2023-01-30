package controller;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import model.Entry;
import model.HotelBooking;
import model.Session;

public class ClientController {

    static HotelBooking stub;
    Session session = null;

    public static void main(String[] args) throws RemoteException {
        // System.setSecurityManager(new SecurityManager());

        FrontController frontController;
        Entry entry;
        frontController = new FrontController();
        entry = new Entry();
        try {
            String name = "localhost12";
            stub = (HotelBooking) Naming.lookup(name);

            //sending request to front controller for login
            frontController.dispatchRequest(entry.login());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method for admin login
    public boolean adminLogin(String userName, String password) {
        boolean val = true;
        try {
            //calling the method through stub
            val = stub.adminLogin(userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return val;
    }

    //method for guest login
    public boolean guestLogin(String userName, String password) {
        boolean val = false;
        try {
            //calling the method through stub
            val = stub.guestLogin(userName, password);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return val;
    }

    //method for processing login
    public Session processLogin(String userType, String userName) {
        try {
            //calling the method through stub
            session = stub.processLogin(userType, userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return session;
    }

    //method for browsing rooms
    public List<String> browseRooms() {
        List<String> rooms = new ArrayList<>();
        try {
            //calling the method through stub
            rooms = stub.browseRooms();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rooms;
    }

    //method for viewing users
    public List<String> viewUsers(String type) {
        List<String> users = new ArrayList<>();
        try {
            //calling the method through stub
            users = stub.viewUsers(type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    //method for deleting a user
    public void deleteUser(String type, String email) {
        try {
            //calling the method through stub
            if (stub.deleteUser(type, email)) {
                System.out.println("-------------------------");
                System.out.println(type + " deleted successfully");
                System.out.println("-------------------------");
            } else {
                System.out.println("--------------");
                System.out.println(type + " not found");
                System.out.println("--------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method for deleting a room
    public void deleteRoom(String roomNo) {
        try {
            //calling the method through stub
            if (stub.deleteRoom(roomNo)) {
                System.out.println("-------------------------");
                System.out.println("Room deleted successfully");
                System.out.println("-------------------------");
            } else {
                System.out.println("--------------");
                System.out.println("Room not found");
                System.out.println("--------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method for adding a room
    public void addRoom(String operation, String roomNo, String type, String description, String price, String rating,
            String noOfBeds,
            String typeOfBed, String isSmokingAllowed, String isAvailable) {
        try {
            //calling the method through stub
            if (stub.addRoom(operation, roomNo, type, description, price, rating, noOfBeds, typeOfBed, isSmokingAllowed,
                    isAvailable)) {
                System.out.println("-----------------------");
                if (operation == "Add")
                    System.out.println("Room added successfully");
                else
                    System.out.println("Room updated successfully");
                System.out.println("-----------------------");
            } else {
                System.out.println("--------------------------");
                if (operation == "Add")
                    System.out.println("Room number already exists");
                else
                    System.out.println("Room not found");
                System.out.println("--------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method for registering an admin
    public void adminRegister(Boolean isAdmin, String userName, String email, String password) {
        try {
            //calling the method through stub
            if (stub.adminRegister(userName, email, password)) {
                System.out.println("-----------------------");
                System.out.println("Resigtration successful");
                System.out.println("-----------------------");
                if (!isAdmin) {
                    FrontController frontController;
                    Entry entry;
                    frontController = new FrontController();
                    entry = new Entry();
                    frontController.dispatchRequest(entry.login());
                }
            } else {
                System.out.println("-----------------------");
                System.out.println("Email id already exists");
                System.out.println("-----------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method for registering a guest
    public void guestRegister(Boolean isAdmin, String userName, String email, String password) {
        try {
            //calling the method through stub
            if (stub.guestRegister(userName, email, password)) {
                System.out.println("-----------------------");
                System.out.println("Resigtration successful");
                System.out.println("-----------------------");
                if (!isAdmin) {
                    FrontController frontController;
                    Entry entry;
                    frontController = new FrontController();
                    entry = new Entry();
                    frontController.dispatchRequest(entry.login());
                }
            } else {
                System.out.println("-----------------------");
                System.out.println("Email id already exists");
                System.out.println("-----------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method for booking a room
    public void reserveRoom(String roomNo, String email, int days, String address, String mobileNo, String cardNo) {
        try {
            //calling the method through stub to check if room is available
            String availability = stub.checkRoomAvailability(roomNo, days, true);
            if(!availability.equals("Sorry this room is not available")) {
                //calling the method through stub to reserve the room
                stub.reserveRoom(roomNo, email, days, address, mobileNo, cardNo);
            }
            System.out.println("---------------------------------");
            System.out.println(availability);
            System.out.println("---------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method for viewing current reservations
    public List<String> viewBookings(String role, String email) {
        List<String> bookings = new ArrayList<>();
        try {
            //calling the method through stub
            bookings = stub.viewBookings(role, email);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookings;
    }

    //method for modifying the reservation
    public void modifyReservation(String roomNo, String newRoonNo, String email, int days) {
        try {
            //calling the method through stub to check if room is available
            String availability = stub.checkRoomAvailability(newRoonNo, days, false);
            if(!availability.equals("Sorry this room is not available")) {
                //calling the method through stub to modify reservation
                stub.modifyReservation(roomNo, newRoonNo, email, days);
            }
            System.out.println("---------------------------------");
            System.out.println(availability);
            System.out.println("---------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method for calcelling the reservation
    public void cancelReservation(String roomNo, String email) {
        try {
            //calling the method through stub
            String availability = stub.cancelReservation(roomNo, email);
            System.out.println("---------------------------------");
            System.out.println(availability);
            System.out.println("---------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
