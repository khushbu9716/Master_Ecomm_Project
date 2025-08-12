package com.scaler.userservice.services;

import ch.qos.logback.core.joran.sanity.Pair;
import com.scaler.userservice.dtos.requests.SignupRequestDto;
import com.scaler.userservice.model.Token;
import com.scaler.userservice.model.User;

public interface IAuthService {

    User signup(SignupRequestDto user);
    Token login(String mail, String password);
    //Validate token Method should return User since after validating it we will give user details
    User validateToken(String token);

}
