package model;

public class AuthorizationException extends RuntimeException {
    public AuthorizationException(String methodName) {
        //gets the name of the method for which, the access is denied and throws this exception
        super("Invalid Authorization - Access Denined to " + methodName + "() function!");
    }
}
