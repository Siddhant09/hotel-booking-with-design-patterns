package model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Database extends UnicastRemoteObject {
    
    //creating a list of users
    public static List<User> users = new ArrayList<User>();
    
    //creating a list of rooms
    public static List<Room> rooms = new ArrayList<Room>();
    
    //creating a list of bookings
    public static List<Booking> bookings = new ArrayList<Booking>();

    public Database() throws RemoteException {
        super();
    }

    //method to create databse
    public static void createData() throws RemoteException {
        try {
            System.out.println("Data created");

            User admin = new User();
            admin.setName("Super Admin");
            admin.setEmail("admin@grandhotel.com");
            admin.setPassword("Admin@123");
            admin.setRole("Admin");
            users.add(admin);
            
            User admin2 = new User();
            admin2.setName("John");
            admin2.setEmail("john@grandhotel.com");
            admin2.setPassword("John@123");
            admin2.setRole("Admin");
            users.add(admin2);
            
            User guest1 = new User();
            guest1.setName("Emma");
            guest1.setEmail("emma@gmail.com");
            guest1.setPassword("Emma@123");
            guest1.setRole("Guest");
            users.add(guest1);
            
            User guest2 = new User();
            guest2.setName("Adam");
            guest2.setEmail("adam@gmail.com");
            guest2.setPassword("Adam@123");
            guest2.setRole("Guest");
            users.add(guest2);

            Room room1 = new Room();
            room1.setRoomNo("101");
            room1.setType("Single");
            room1.setDescription("Single room, smoking is not allowed");
            room1.setPrice("25");
            room1.setRating("3");
            room1.setNoOfBeds("1");
            room1.setTypeOfBed("Single Bed");
            room1.setSmokingAllowed("No");
            room1.setAvailable("Yes");
            rooms.add(room1);

            Room room2 = new Room();
            room2.setRoomNo("102");
            room2.setType("Twin");
            room2.setDescription("Single room, smoking is allowed");
            room2.setPrice("30");
            room2.setRating("3");
            room2.setNoOfBeds("2");
            room2.setTypeOfBed("Single Bed");
            room2.setSmokingAllowed("Yes");
            room2.setAvailable("Yes");
            rooms.add(room2);

            Room room3 = new Room();
            room3.setRoomNo("201");
            room3.setType("Double");
            room3.setDescription("Single room, smoking is not allowed");
            room3.setPrice("35");
            room3.setRating("4");
            room3.setNoOfBeds("1");
            room3.setTypeOfBed("Double Bed");
            room3.setSmokingAllowed("No");
            room3.setAvailable("Yes");
            rooms.add(room3);

            Room room4 = new Room();
            room4.setRoomNo("202");
            room4.setType("Double");
            room4.setDescription("Single room, smoking is allowed");
            room4.setPrice("40");
            room4.setRating("4");
            room4.setNoOfBeds("1");
            room4.setTypeOfBed("Double Bed");
            room4.setSmokingAllowed("Yes");
            room4.setAvailable("No");
            rooms.add(room4);

            Room room5 = new Room();
            room5.setRoomNo("301");
            room5.setType("Pent House");
            room5.setDescription("Pent house, without view, smoking is allowed");
            room5.setPrice("45");
            room5.setRating("4");
            room5.setNoOfBeds("1");
            room5.setTypeOfBed("Queen Bed");
            room5.setSmokingAllowed("Yes");
            room5.setAvailable("Yes");
            rooms.add(room5);

            Room room6 = new Room();
            room6.setRoomNo("302");
            room6.setType("Pent House");
            room6.setDescription("Pent house, with amazing view, smoking is allowed");
            room6.setPrice("50");
            room6.setRating("5");
            room6.setNoOfBeds("1");
            room6.setTypeOfBed("King Bed");
            room6.setSmokingAllowed("Yes");
            room6.setAvailable("No");
            rooms.add(room6);

            Booking booking1 = new Booking();
            booking1.setEmail("emma@gmail.com");
            booking1.setRoomNo("202");
            booking1.setDays(2);
            booking1.setAddress("Indianapolis");
            booking1.setMobileNo("9999999999");
            booking1.setCardNo("4444555566667777");
            booking1.setCancelled("No");
            booking1.setAmount(80);
            bookings.add(booking1);

            Booking booking2 = new Booking();
            booking2.setEmail("adam@gmail.com");
            booking2.setRoomNo("302");
            booking2.setDays(4);
            booking2.setAddress("Indianapolis");
            booking2.setMobileNo("7777777777");
            booking2.setCardNo("1111222233334444");
            booking2.setCancelled("No");
            booking1.setAmount(200);
            bookings.add(booking2);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
