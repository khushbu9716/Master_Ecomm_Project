package com.scaler.userservice.dtos.reponse;

import com.scaler.userservice.model.User;

public class LoginResp {
    public User user;
    private String token;

    public LoginResp(User user, String token){
        this.user = user;
        this.token = token;
    }
}
