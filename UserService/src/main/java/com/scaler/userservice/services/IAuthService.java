package com.scaler.userservice.services;

import ch.qos.logback.core.joran.sanity.Pair;
import com.scaler.userservice.dtos.requests.SignupRequestDto;
import com.scaler.userservice.model.User;

public interface IAuthService {

    User signup(SignupRequestDto user);
    Pair<User, String> login(String mail, String password);
}
