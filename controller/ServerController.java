package controller;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import model.Database;
import model.HotelBooking;
import model.HotelBookingImpl;

public class ServerController extends UnicastRemoteObject { 

    protected ServerController() throws RemoteException {
        super();
    }

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        try {
            Database.createData();
            HotelBooking stub = new HotelBookingImpl();

            //binding the name of the stub
            Naming.rebind("localhost12", stub);

            System.out.println("Grand Hotel Server Started");
        }
        catch(Exception ex) {
            System.out.println("Server error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
