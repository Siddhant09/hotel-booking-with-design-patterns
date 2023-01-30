package model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class HotelBookingImpl extends UnicastRemoteObject implements HotelBooking {

    public HotelBookingImpl() throws RemoteException {
        super();
    }

    //method for registering an admin
    @Override
    public boolean adminRegister(String userName, String email, String password) throws RemoteException {
        try {
            //checking if user already exists
            User userExists = null;
            for (User user : Database.users) {
                if (user.getEmail().equals(email)) {
                    userExists = user;
                }
            }

            if (userExists != null)
                return false;

            //creating new user
            User user = new User();
            user.setName(userName);
            user.setEmail(email);
            user.setPassword(password);
            user.setRole("Admin");
            Database.users.add(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //method for registering a guest
    @Override
    public boolean guestRegister(String userName, String email, String password) throws RemoteException {
        try {
            //checking if user already exists
            User userExists = null;
            for (User user : Database.users) {
                if (user.getEmail().equals(email)) {
                    userExists = user;
                }
            }

            if (userExists != null)
                return false;

            //adding new user
            User user = new User();
            user.setName(userName);
            user.setEmail(email);
            user.setPassword(password);
            user.setRole("Guest");
            Database.users.add(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //method for admin login
    @Override
    public boolean adminLogin(String userName, String password) throws RemoteException {
        try {
            for (User user : Database.users) {
                if (user.getEmail().equals(userName) && user.getPassword().equals(password)
                        && user.getRole().equals("Admin")) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //method for guest login
    @Override
    public boolean guestLogin(String userName, String password) throws RemoteException {
        try {
            for (User user : Database.users) {
                if (user.getEmail().equals(userName) && user.getPassword().equals(password)
                        && user.getRole().equals("Guest")) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //method for processing login
    @Override
    public Session processLogin(String userType, String userName) throws RemoteException {
        try {
            //creating a new session
            Session session = new Session(userType, userName);
            return session;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //method for browsing rooms
    @Override
    public List<String> browseRooms() throws RemoteException {
        List<String> rooms = new ArrayList<>();
        try {
            for (Room room : Database.rooms) {
                rooms.add("Room No: " + room.getRoomNo() + " | " + "Type: " + room.getType() + " | " + "Description: "
                        + room.getDescription() + " | " +
                        "Price: " + room.getPrice() + " | " + "Rating:" + room.getRating() + " | " + "No of beds: "
                        + room.getNoOfBeds() + " | " +
                        "Type of bed: " + room.getTypeOfBed() + " | " + "Smoking allowed: " + room.isSmokingAllowed()
                        + " | " + "Available: " + room.isAvailable());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rooms;
    }

    //method for adding a room
    @Override
    public boolean addRoom(String operation, String roomNo, String type, String description, String price,
            String rating, String noOfBeds,
            String typeOfBed, String isSmokingAllowed, String isAvailable) throws RemoteException {
        try {
            //checking if room exists
            Room oldRoom = null;
            for (Room item : Database.rooms) {
                if (item.getRoomNo().equals(roomNo))
                    oldRoom = item;
            }
            if (operation.equals("Add")) {
                if (oldRoom != null)
                    return false;
            } else {
                if (oldRoom == null)
                    return false;
                else {
                    //removing existing room
                    Database.rooms.remove(oldRoom);
                    if (isAvailable.equals("No")) {
                        Booking existingBooking = null;
                        for (Booking booking : Database.bookings)
                            if (roomNo.equals(booking.getRoomNo()))
                                existingBooking = booking;

                        if (existingBooking != null)
                            Database.bookings.remove(existingBooking);
                    }
                }
            }

            //adding a new room
            Room room = new Room(roomNo, type, description, price, rating, noOfBeds, typeOfBed, isSmokingAllowed, isAvailable);
            Database.rooms.add(room);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //method for deleting a room
    @Override
    public boolean deleteRoom(String roomNo) throws RemoteException {
        try {
            //checking if room exists
            Room room = null;
            for (Room item : Database.rooms) {
                if (item.getRoomNo().equals(roomNo))
                    room = item;
            }
            //deleting the room
            if (room != null) {
                Database.rooms.remove(room);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //method for viewing users
    @Override
    public List<String> viewUsers(String type) throws RemoteException {
        List<String> users = new ArrayList<>();
        try {
            for (User user : Database.users) {
                if (user.getRole().equals(type))
                    users.add("User Name: " + user.getName() + " | " + "Email: " + user.getEmail());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    //method for deleting a user
    @Override
    public boolean deleteUser(String type, String email) throws RemoteException {
        try {
            //checking if user exists
            User user = null;
            for (User item : Database.users) {
                if (item.getEmail().equals(email) && item.getRole().equals(type))
                    user = item;
            }
            //deleting the user
            if (user != null) {
                Database.users.remove(user);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //methods for checking if room is available
    @Override
    public String checkRoomAvailability(String roomNo, int days, boolean isNew) throws RemoteException {
        String result = "Sorry this room is not available";
        try {
            int price = 0;
            boolean isAvailable = false;

            //checking if roomn is available
            for (Room item : Database.rooms) {
                if (item.getRoomNo().equals(roomNo) && item.isAvailable().equals("Yes")) {
                    isAvailable = true;
                    //calculating te price
                    price = Integer.parseInt(item.getPrice()) * days;
                }
            }

            if (isAvailable) {
                if (isNew)
                    result = "Booking confirmed. Total price: $" + price + ". Payment Successful";
                else
                    result = "Booking updated. Total price: $" + price + ". Payment Successful";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //method for booking a room
    @Override
    public boolean reserveRoom(String roomNo, String email, int days, String address, String mobileNo, String cardNo)
            throws RemoteException {
        try {
            int price = 0;
            Room oldRoom = null;
            //getting room details
            for (Room item : Database.rooms) {
                if (item.getRoomNo().equals(roomNo)) {
                    oldRoom = item;
                    //calculating the price
                    price = Integer.parseInt(item.getPrice()) * days;
                }
            }
            //setting availability as no
            oldRoom.setAvailable("No");

            //creating a new booking
            Booking booking = new Booking();
            booking.setEmail(email);
            booking.setRoomNo(roomNo);
            booking.setDays(days);
            booking.setAddress(address);
            booking.setMobileNo(mobileNo);
            booking.setCardNo(cardNo);
            booking.setAmount(price);
            booking.setCancelled("No");

            Database.bookings.add(booking);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //method for viewing current reservations
    @Override
    public List<String> viewBookings(String role, String email) throws RemoteException {
        List<String> bookings = new ArrayList<>();
        try {
            for (Booking booking : Database.bookings) {
                if ((role.equals("Admin") || email.equals(booking.getEmail())) && booking.isCancelled().equals("No"))
                    bookings.add("Guest Email: " + booking.getEmail() + " | " + "Room No: " + booking.getRoomNo()
                            + " | " + "Days: " + booking.getDays() + " | " +
                            "Address: " + booking.getAddress() + " | " + "Mobile No:" + booking.getMobileNo() + " | "
                            + "Credit Card No: "
                            + booking.getCardNo() + " | " + " | " + "Price: " + booking.getAmount());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookings;
    }

    //method for modifying the reservation
    @Override
    public String modifyReservation(String roomNo, String newRoonNo, String email, int days) throws RemoteException {
        String result = "Sorry this room is not available";
        try {
            //checking is booking exists
            Booking existingBooking = null;
            for (Booking booking : Database.bookings)
                if (roomNo.equals(booking.getRoomNo()) && email.equals(booking.getEmail()) && booking.isCancelled().equals("No"))
                    existingBooking = booking;

            if (existingBooking != null) {
                //checking is the new room is available
                result = checkRoomAvailability(newRoonNo, days, false);
                if (!result.equals("Sorry this room is not available")) {
                    //updating the booking
                    existingBooking.setRoomNo(newRoonNo);
                    existingBooking.setDays(days);
                    Room oldRoom = null;
                    for (Room item : Database.rooms) {
                        if (item.getRoomNo().equals(roomNo)) {
                            oldRoom = item;
                        }
                    }
                    //updating availability of old room as yes
                    oldRoom.setAvailable("Yes");
                }
            } else
                result = "Booking not found";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //method for calcelling the reservation
    @Override
    public String cancelReservation(String roomNo, String email) throws RemoteException {
        String result = "Booking not found";
        try {
            //checking is booking exists
            Booking existingBooking = null;
            for (Booking booking : Database.bookings)
                if (roomNo.equals(booking.getRoomNo()) && email.equals(booking.getEmail()) && booking.isCancelled().equals("No"))
                    existingBooking = booking;

            //getting room details
            Room room = null;
            for (Room item : Database.rooms) {
                if (item.getRoomNo().equals(roomNo))
                    room = item;
            }

            //cancelling the ooking
            if (existingBooking != null) {
                existingBooking.setCancelled("Yes");
                if (room != null)
                    room.setAvailable("Yes");

                //calculating cancellation price
                int price = existingBooking.getAmount();
                price = (price * 10) / 100;
                result = "Booking cancelled successfully. Cancellation charges(10%) $" + price + ". Balance amount will be credit to your account";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
