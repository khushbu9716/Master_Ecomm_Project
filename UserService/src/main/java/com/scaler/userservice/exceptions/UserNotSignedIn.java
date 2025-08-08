package com.scaler.userservice.exceptions;

public class UserNotSignedIn extends RuntimeException{
    public  UserNotSignedIn(String message){
        super(message);
    }
}
