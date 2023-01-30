package controller;

import model.Dispatcher;
import model.Entry;
import model.Session;

public class FrontController {

    private Dispatcher dispatcher;
    private Session session = null;
    private ClientController clientController = new ClientController();
    private Entry entry = new Entry();

    public FrontController() {

        dispatcher = new Dispatcher();
    }

    // methods to check if user is authentic
    private boolean isAuthenticUser(String view) {
        // if user if admin
        if (view.equalsIgnoreCase("Admin")) {
            entry.adminLogin();

            String email = entry.getEmail();
            String pass = entry.getPassword();

            //login for admin
            if (clientController.adminLogin(email, pass)) {
                session = clientController.processLogin("Admin", email);
                return true;
            }

            // user is guest
        } else if (view.equalsIgnoreCase("Guest")) {

            entry.guestLogin();
            String email = entry.getEmail();
            String pass = entry.getPassword();

            //login for guest
            if (clientController.guestLogin(email, pass)) {
                session = clientController.processLogin("Guest", email);
                return true;
            }

            //for new admin
        } else if (view.equalsIgnoreCase("New Admin")) {
            entry.registration();

            String email, userName, password;
            email = entry.getEmail();
            userName = entry.getUserName();
            password = entry.getPassword();

            //registering new user
            clientController.adminRegister(false, userName, email, password);
            return true;

            //for nww guest
        } else if (view.equalsIgnoreCase("New Guest")) {
            entry.registration();

            String email, userName, password;
            email = entry.getEmail();
            userName = entry.getUserName();
            password = entry.getPassword();

            //registering new user
            clientController.guestRegister(false, userName, email, password);
            return true;
        }

        return false;
    }

    //method to dispatch the request
    public void dispatchRequest(String view) {
        if (isAuthenticUser(view))
            dispatcher.dispatch(view, session);
        else
            dispatcher.dispatchError("ERROR");
    }
}
