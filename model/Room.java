package model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Room extends UnicastRemoteObject {

    protected Room() throws RemoteException {
        super();
    }  

    public Room(String roomNo, String type, String description, String price, String rating, String noOfBeds,
            String typeOfBed, String isSmokingAllowed, String isAvailable) throws RemoteException {
        this.roomNo = roomNo;
        this.type = type;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.noOfBeds = noOfBeds;
        this.typeOfBed = typeOfBed;
        this.isSmokingAllowed = isSmokingAllowed;
        this.isAvailable = isAvailable;
    }

    private String roomNo;
    private String type;
    private String description;
    private String price;
    private String rating;
    private String noOfBeds;
    private String typeOfBed;
    private String isSmokingAllowed;
    private String isAvailable;  

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

}
