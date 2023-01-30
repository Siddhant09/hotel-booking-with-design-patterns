package model;

import java.util.List;
import java.util.Scanner;

import controller.ClientController;
import view.AdminMenuView;
import view.CurrentSessionView;

public class ConcreteAdmin implements Admin {

    private ClientController clientController;

    public ConcreteAdmin() {
        clientController = new ClientController();
    }

    //method to display menu
    @Override
    public int display(Session session) {
        int i = 0;

        //displaying current session details
        CurrentSessionView.DisplayCurrentSessionView(session);

        //displaying admin menu
        AdminMenuView.DisplayAdminMenuView();
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
            //displaying list of rooms
            System.out.println("-------------");
            System.out.println("List of rooms");
            System.out.println("-------------");
            
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

    //method to view users
    @Override
    public void viewUsers(String type) {
        try {
            //displaying list of users
            System.out.println("-------------");
            System.out.println("List of " + type);
            System.out.println("-------------");
            
            //calling method from controller
            List<String> users = clientController.viewUsers(type);
            int count = 1;
            for (String user : users) {
                System.out.println(count + ". " + user);
                count++;
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    //method to delete user
    @Override
    public void deleteUser(String type) {
        try {
            //fetching user input
            Entry entry = new Entry();
            entry.getUserForDelete();
            String email = entry.getEmail();

            //calling method from controller
            clientController.deleteUser(type, email);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    //method to delete room
    @Override
    public void deleteRoom() {
        try {
            //fetching user input
            Entry entry = new Entry();
            entry.getRoomForDelete();
            String roomNo = entry.getEmail();
            
            //calling method from controller
            clientController.deleteRoom(roomNo);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    //method to add room
    @Override
    public void addRoom(String operation) {
        try {
            //fetching user input
            Entry entry = new Entry();
            entry.getRoomForAdd(operation);
            String roomNo = entry.getRoomNo();
            String type = entry.getRoomType();
            String description = entry.getDescription();
            String price = entry.getPrice();
            String rating = entry.getRating();
            String noOfBeds = entry.getNoOfBeds();
            String typeOfBed = entry.getTypeOfBed();
            String isSmokingAllowed = entry.isSmokingAllowed();
            String isAvailable = entry.isAvailable();
            
            //calling method from controller
            clientController.addRoom(operation, roomNo, type, description, price, rating, noOfBeds, typeOfBed, isSmokingAllowed, isAvailable);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    //method to add user
    @Override
    public void addUser(String type) {
        try {
            //fetching user input
            Entry entry = new Entry();
            entry.registration();
            String email = entry.getEmail();
            String userName = entry.getUserName();
            String password = entry.getPassword();
            
            //calling method from controller
            if(type == "Admin")
                clientController.adminRegister(true, userName, email, password);
            else    
                clientController.guestRegister(true, userName, email, password);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
