package model;

import java.io.Serializable;

public class Session implements Serializable{

    private  Role role;

    //instantiating the role class to get role
    public Session(String userRole, String userName)
    {
        this.role = new Role(userRole, userName);
    }

    //method to get session details
    public Role getUser() {

        return role;
    }

}