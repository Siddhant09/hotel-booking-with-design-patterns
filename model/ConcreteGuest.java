package model;

import java.util.List;
import java.util.Scanner;

import controller.ClientController;
import view.CurrentSessionView;
import view.GuestMenuView;

public class ConcreteGuest implements Guest {

    private ClientController clientController;

    public ConcreteGuest() {
        clientController = new ClientController();
    }

    //method to dsplay menu
    @Override
    public int display(Session session) {
        int i = 0;

        //displaying current session details
        CurrentSessionView.DisplayCurrentSessionView(session);

        //displaying guest menu
        GuestMenuView.DisplayGuestMenu();

        Scanner sc = new Scanner(System.in);
        try {
            //fetching user input
            i = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println(e);
        }
        return i;
    }

    //method to browse rooms
    @Override
    public void browseRooms() {
        try {
            //calling method from controller
            List<String> rooms = clientController.browseRooms();
            int count = 1;
            for (String room : rooms) {
                System.out.println(count + ". " + room);
                count++;
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    //method to book a room
    @Override
    public void reserveRoom(Session session) {
        try {
            //deisplaying list of rooms
            System.out.println("-------------");
            System.out.println("List of rooms");
            System.out.println("-------------");
            List<String> rooms = clientController.browseRooms();
            int count = 1;
            for (String room : rooms) {
                System.out.println(count + ". " + room);
                count++;
            }

            //fetching user input
            Entry entry = new Entry();
            entry.getBookingDetails();
            String roomNo = entry.getRoomNo();
            int days = entry.getDays();
            String address = entry.getAddress();
            String mobileNo = entry.getMobileNo();
            String cardNo = entry.getCardNo();
            String email = session.getUser().getUserName();
            
            //calling method from controller
            clientController.reserveRoom(roomNo, email, days, address, mobileNo, cardNo);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    //method to modify a reservation
    @Override
    public void modifyReservation(Session session) {
        try {
            String role = session.getUser().getRoleType();
            String email = session.getUser().getUserName();

            //deisplaying list of bookings
            List<String> rooms = clientController.viewBookings(role, email);
            if (rooms.size() > 0) {
                System.out.println("----------------");
                System.out.println("List of bookings");
                System.out.println("----------------");
                int count = 1;
                for (String room : rooms) {
                    System.out.println(count + ". " + room);
                    count++;
                }

                //fetching user input
                Entry entry = new Entry();
                entry.getModifyBookingDetails();
                String roomNo = entry.getRoomNo();
                int days = entry.getDays();
                String newRoomNo = entry.getAddress();
                
            //calling method from controller
                clientController.modifyReservation(roomNo, newRoomNo, email, days);
            } else {
                System.out.println("------------------------");
                System.out.println("No bookings at this time");
                System.out.println("------------------------");
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    //method to cancel a reservation
    @Override
    public void cancelReservation(Session session) {
        try {
            String role = session.getUser().getRoleType();
            String email = session.getUser().getUserName();

            //deisplaying list of bookings
            List<String> rooms = clientController.viewBookings(role, email);
            if (rooms.size() > 0) {
                System.out.println("----------------");
                System.out.println("List of bookings");
                System.out.println("----------------");
                int count = 1;
                for (String room : rooms) {
                    System.out.println(count + ". " + room);
                    count++;
                }

                //fetching user input
                Entry entry = new Entry();
                entry.getCancelookingDetails();
                String roomNo = entry.getRoomNo();
                
                //calling method from controller
                clientController.cancelReservation(roomNo, email);
            } else {
                System.out.println("------------------------");
                System.out.println("No bookings at this time");
                System.out.println("------------------------");
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
