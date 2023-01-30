package model;

import java.util.ArrayList;
import java.util.List;

public class Invoker {

    private List<Command> orderList = new ArrayList<Command>();

    // takes the list of commands to process and stores them in the arraylist
    public void takeCommand(Command command) {
        orderList.add(command);
    }

    // takes the List as input and executes each command from the list
    public void placeCommand() {

        for (Command command : orderList) {
            command.execute();
        }
        // clears the list of commands
        orderList.clear();
    }
}
