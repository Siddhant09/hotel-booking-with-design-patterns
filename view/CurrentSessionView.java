package view;

import model.Session;

public class CurrentSessionView {

    //method to print current session details
    public static void DisplayCurrentSessionView(Session session) {
        System.out.println();
        System.out.println("====================================================================================");
        System.out.println("Current session -  Role: " + session.getUser().getRoleType() + " | Email: " + session.getUser().getUserName());
        System.out.println("====================================================================================");
        System.out.println();
    }
    
}
