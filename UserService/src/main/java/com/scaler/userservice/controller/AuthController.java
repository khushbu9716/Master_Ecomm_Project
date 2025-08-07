package com.scaler.userservice.controller;

import com.scaler.userservice.dtos.UserDto;
import com.scaler.userservice.dtos.requests.LoginReqDto;
import com.scaler.userservice.dtos.requests.SignupRequestDto;
import com.scaler.userservice.model.Role;
import com.scaler.userservice.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//for sending api json
public class AuthController {

    //signup

    @PostMapping("/signup")
    public UserDto signup(@RequestBody SignupRequestDto user) {
        return null;

    }

    //login-> post mapping, we are creating token
    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody LoginReqDto user) {
        return null;
    }



}
