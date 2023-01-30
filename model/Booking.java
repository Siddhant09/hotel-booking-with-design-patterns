package model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Booking extends UnicastRemoteObject {

    public Booking() throws RemoteException {
        super();
    }
    public Booking(String roomNo, String email, int days, String address, String mobileNo, String cardNo, String isCancelled, int amount) throws RemoteException {
        this.roomNo = roomNo;
        this.email = email;
        this.days = days;
        this.setAddress(address);
        this.setMobileNo(mobileNo);
        this.setCardNo(cardNo);
        this.isCancelled = isCancelled;
        this.setAmount(amount);
    }

    private String roomNo;
    private String email;
    private int days;
    private String address;
    private String mobileNo;
    private String cardNo;
    private String isCancelled;
    private int amount;

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String isCancelled() {
        return isCancelled;
    }

    public void setCancelled(String isCancelled) {
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
    public int getAmount() {
        return amount;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
}
