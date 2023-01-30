package model;


import java.io.Serializable;

public class Role implements Serializable{

    private String userRole, userName, firstName;

    public Role(String userRole, String userName)
    {
        this.userRole=userRole;
        this.userName = userName;
    }

    public String getRoleType(){

        return userRole;
    }
    
    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }
}