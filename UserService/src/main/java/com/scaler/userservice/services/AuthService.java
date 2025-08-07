package com.scaler.userservice.services;

import ch.qos.logback.core.joran.sanity.Pair;
import com.scaler.userservice.dtos.UserDto;
import com.scaler.userservice.dtos.requests.SignupRequestDto;
import com.scaler.userservice.model.User;
import com.scaler.userservice.repos.RoleRepo;
import com.scaler.userservice.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepo userRepo;
    private RoleRepo roleRepo;

    public User  signup(SignupRequestDto user) {
        //service is internal so it will talk in terms of model so we will return User
        
        return null;

    }

    public Pair<User, String> login(){
        //this should return User and one string token so we can make a pair and return

        return null;
    }

    private UserDto from(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setRoles(user.getRoles());
        userDto.setUserName(user.getUsername());
        return userDto;
    }
}
