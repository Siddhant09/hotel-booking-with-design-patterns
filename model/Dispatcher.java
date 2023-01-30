package model;

import view.ErrorView;

public class Dispatcher {

    private AbstractFactory adminFactory;
    private AbstractFactory guestFactory;

    public Dispatcher() {
        adminFactory = FactoryProducer.getFactory("Admin");
        guestFactory = FactoryProducer.getFactory("Guest");
    }

    //method to dispatch a request to proper command
    public void dispatch(String view, Session session) {
        int option = 0;

        //if user is admin
        if (view.equalsIgnoreCase("Admin")) {
            //creating an instance of admin factory
            Admin admin = adminFactory.getAdmin("Admin");

            //creating an instance of invoker
            Invoker invoker = new Invoker();

            while (true) {
                //displaying mernu
                option = admin.display(session);
                switch (option) {
                    case 1: {
                        //creating instance of appropriate command and invoking it
                        Command cmd = new ConcreteBrowseRooms(admin);
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    case 2: {
                        //creating instance of appropriate command and invoking it
                        Command cmd = new ConcreteAddRoom(admin, "Add");
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    case 3: {
                        //creating instance of appropriate command and invoking it
                        Command cmd = new ConcreteAddRoom(admin, "Update");
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    case 4: {
                        //creating instance of appropriate command and invoking it
                        Command cmd = new ConcreteDeleteRoom(admin);
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    case 5: {
                        //creating instance of appropriate command and invoking it
                        Command cmd = new ConcreteViewUser(admin, "Guest");
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    case 6: {
                        //creating instance of appropriate command and invoking it
                        Command cmd = new ConcreteAddUser(admin, "Guest");
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    case 7: {
                        //creating instance of appropriate command and invoking it
                        Command cmd = new ConcreteDeleteUser(admin, "Guest");
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    case 8: {
                        //creating instance of appropriate command and invoking it
                        Command cmd = new ConcreteViewUser(admin, "Admin");
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    case 9: {
                        //creating instance of appropriate command and invoking it
                        Command cmd = new ConcreteAddUser(admin, "Admin");
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    case 10: {
                        //creating instance of appropriate command and invoking it
                        Command cmd = new ConcreteDeleteUser(admin, "Admin");
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    case 11: {
                        //exiting the app
                        System.out.print("\033[H\033[2J");  
                        System.out.flush(); 
                        System.out.println("Thank you for using the app");            
                        //exiting the application
                        System.exit(0);
                    }
                    default:
                        System.out.println("Invalid input, please select a valid option");
                        break;
                }
            }

            //if user is a guest
        } else if (view.equalsIgnoreCase("Guest")) {

            //creating an instance of guest factory
            Guest guest = guestFactory.getUser("Guest");

            //creating an instance of invoker
            Invoker invoker = new Invoker();

            while (true) {
                option = guest.display(session);
                switch (option) {
                    case 1: {
                        //creating instance of appropriate command and invoking it
                        Command cmd = new ConcreteGuestBrowseRooms(guest);
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    case 2: {
                        //creating instance of appropriate command and invoking it
                        Command cmd = new ConcreteReserveRoom(guest, session);
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    case 3: {
                        //creating instance of appropriate command and invoking it
                        Command cmd = new ConcerteModifyBooking(guest, session);
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    case 4: {
                        //creating instance of appropriate command and invoking it
                        Command cmd = new ConcreteCancelBooking(guest, session);
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    case 5: {
                        //exiting the app
                        System.out.print("\033[H\033[2J");  
                        System.out.flush(); 
                        System.out.println("Thank you for using the app");            
                        //exiting the application
                        System.exit(0);
                    }
                    default:
                        System.out.println("Invalid input, please select a valid option");
                        break;
                }
            }
        }
    }

    //method to display error
    public void dispatchError(String view) {
        if (view.equalsIgnoreCase("ERROR")) {
            ErrorView obj = new ErrorView();
            obj.print();

        }
    }

}
