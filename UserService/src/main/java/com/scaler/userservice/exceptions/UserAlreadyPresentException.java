package com.scaler.userservice.exceptions;

public class UserAlreadyPresentException extends RuntimeException{

    public UserAlreadyPresentException(String message){
        super(message);
    }
}
