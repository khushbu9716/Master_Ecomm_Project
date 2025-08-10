package com.scaler.userservice.controller;

import ch.qos.logback.core.joran.sanity.Pair;
import com.scaler.userservice.dtos.UserDto;
import com.scaler.userservice.dtos.requests.LoginReqDto;
import com.scaler.userservice.dtos.requests.SignupRequestDto;
import com.scaler.userservice.model.Role;
import com.scaler.userservice.model.User;
import com.scaler.userservice.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//for sending api json
public class AuthController {
    @Autowired
    AuthService authService;

    //signup
    @PostMapping("/signup")
    public UserDto signup(@RequestBody SignupRequestDto user) {
        User userResp = authService.signup(user);
        return from(userResp);

    }

    //login-> post mapping, we are creating token
    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody LoginReqDto user) {
        Pair<User, String> userRes = authService.login(user.getEmail(), user.getPassword());
        UserDto userDto = from(userRes.first);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
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
