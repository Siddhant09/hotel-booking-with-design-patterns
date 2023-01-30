package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import view.HomeView;

public class Entry {

    private int type;
    private String email;
    private String password;
    private String userName;
    private String roomNo;
    private String roomType;
    private String description;
    private String price;
    private String rating;
    private String noOfBeds;
    private String typeOfBed;
    private String isSmokingAllowed;
    private String isAvailable;
    private int days;
    private String address;
    private String mobileNo;
    private String cardNo;
    private String isCancelled;
    private Scanner sc = new Scanner(System.in);

    // method to display main menu
    public String login() {
        // displaying welcome message
        HomeView.DisplayHomeView();

        // fetching user input
        type = Integer.parseInt(sc.nextLine());

        if (type == 1)
            return "Admin";
        else if (type == 2)
            return "Guest";
        else if (type == 3)
            return "New Admin";
        else if (type == 4)
            return "New Guest";

        return "false";
    }

    // fetching user input for admin login
    public void adminLogin() {
        System.out.println("Enter email id: ");
        email = sc.nextLine();

        System.out.println("Enter password: ");
        password = sc.nextLine();
    }

    // fetching user input for guest login
    public void guestLogin() {
        System.out.println("Enter email id: ");
        email = sc.nextLine();

        System.out.println("Enter password: ");
        password = sc.nextLine();
    }

    // fetching user input for registration
    public void registration() {
        System.out.println("Enter name: ");
        userName = sc.nextLine();

        System.out.println("Enter email id: ");
        email = sc.nextLine();

        System.out.println("Enter password: ");
        password = sc.nextLine();

    }

    // fetching user input for deleting a user
    public void getUserForDelete() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter email id of user to be deleted: ");
            email = reader.readLine();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // fetching user input for deleting a room
    public void getRoomForDelete() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter room number to be deleted: ");
            email = reader.readLine();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // fetching user input for adding room
    public void getRoomForAdd(String operation) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                if (operation == "Add")
                    System.out.println("Enter new room number: ");
                else
                    System.out.println("Enter existing room number: ");

                roomNo = reader.readLine();

                System.out.println("Enter room type: ");
                roomType = reader.readLine();

                System.out.println("Enter description: ");
                description = reader.readLine();

                System.out.println("Enter price: ");
                price = reader.readLine();

                System.out.println("Enter rating: ");
                rating = reader.readLine();

                System.out.println("Enter number of beds: ");
                noOfBeds = reader.readLine();

                System.out.println("Enter type of bed: ");
                typeOfBed = reader.readLine();

                System.out.println("Is smoking allowed? (Yes/No): ");
                isSmokingAllowed = reader.readLine();

                System.out.println("Is available? (Yes/No): ");
                isAvailable = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    // fetching user input for new booking
    public void getBookingDetails() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                System.out.println("Enter room number to be reserved: ");
                roomNo = reader.readLine();

                System.out.println("Enter no of days: ");
                days = Integer.parseInt(reader.readLine());

                System.out.println("Enter address: ");
                address = reader.readLine();

                System.out.println("Enter mobile number: ");
                mobileNo = reader.readLine();

                System.out.println("Enter credit card number: ");
                cardNo = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    // fetching user input for modifying booking
    public void getModifyBookingDetails() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                System.out.println("Enter booked room number to be modified: ");
                roomNo = reader.readLine();

                System.out.println("Enter new room number: ");
                address = reader.readLine();

                System.out.println("Enter no of days: ");
                days = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    // fetching user input for cancel booking
    public void getCancelookingDetails() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                System.out.println("Enter booked room number to be cancelled: ");
                roomNo = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getNoOfBeds() {
        return noOfBeds;
    }

    public void setNoOfBeds(String noOfBeds) {
        this.noOfBeds = noOfBeds;
    }

    public String getTypeOfBed() {
        return typeOfBed;
    }

    public void setTypeOfBed(String typeOfBed) {
        this.typeOfBed = typeOfBed;
    }

    public String isSmokingAllowed() {
        return isSmokingAllowed;
    }

    public void setSmokingAllowed(String isSmokingAllowed) {
        this.isSmokingAllowed = isSmokingAllowed;
    }

    public String isAvailable() {
        return isAvailable;
    }

    public void setAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getIsCancelled() {
        return isCancelled;
    }

    public void setIsCancelled(String isCancelled) {
        this.isCancelled = isCancelled;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
