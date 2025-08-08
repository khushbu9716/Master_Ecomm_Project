package com.scaler.userservice.services;

import ch.qos.logback.core.joran.sanity.Pair;
import com.scaler.userservice.dtos.UserDto;
import com.scaler.userservice.dtos.requests.SignupRequestDto;
import com.scaler.userservice.exceptions.UserAlreadyPresentException;
import com.scaler.userservice.exceptions.UserNotSignedIn;
import com.scaler.userservice.model.User;
import com.scaler.userservice.repos.RoleRepo;
import com.scaler.userservice.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepo userRepo;
    private RoleRepo roleRepo;

    public User  signup(SignupRequestDto user) {
        //service is internal so it will talk in terms of model so we will return User
        Optional<User> email = userRepo.findByEmailEquals(user.getEmail());
        if(email.isPresent()){
            throw new UserAlreadyPresentException("User Already Present Exception!!");
        }
        User userResp = new User();
        userResp.setEmail(user.getEmail());
        userResp.setName(user.getName());
        userResp.setName(user.getName());
        userResp.setUsername(user.getUsername());
        userResp.setPassword(user.getPassword()); //TODO: Use Bcrypt
        userResp.setPhoneNumber(user.getPhoneNumber());

        return userRepo.save(userResp);
    }

    public Pair<User, String> login(String email, String password){
        //this should return User and one string token so we can make a pair and return
        Optional<User> userOptional = userRepo.findByEmailEquals(email);
        if(userOptional.isEmpty()){
            throw  new UserNotSignedIn("Please signup first!!");
        }
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
