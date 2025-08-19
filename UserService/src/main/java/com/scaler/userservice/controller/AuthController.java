package com.scaler.userservice.controller;

import com.scaler.userservice.dtos.UserDto;
import com.scaler.userservice.dtos.requests.LoginReqDto;
import com.scaler.userservice.dtos.requests.SignupRequestDto;
import com.scaler.userservice.dtos.reponse.LoginResp;
import com.scaler.userservice.model.Token;
import com.scaler.userservice.model.User;
import com.scaler.userservice.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController  //for sending api json
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    //signup
    @PostMapping("/signup")
    public UserDto signup(@RequestBody SignupRequestDto user) {
        System.out.println("signup");
        User userResp = authService.signup(user);
        return from(userResp);
    }

    //login-> post mapping, we are creating token
    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody LoginReqDto user) {
        Token token = authService.login(user.getEmail(), user.getPassword());
        UserDto userDto = from(token.getUser());
        userDto.setTokenValue(token.getValue());
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping("/validate/{token}")
    public UserDto validateToken(@PathVariable String token) {
        // This method can be used to validate the token
        // You can implement logic to check if the token is valid or not
        // For now, we will just return a 200 OK response
        // authService.validateToken(token);
        // If the token is valid, you can return a success response
        // If the token is invalid, you can throw an exception or return an error response
        System.out.println("Validating token: " + token);
        User tokenUser = authService.validateToken(token);
        return from(tokenUser);
    }

    private UserDto from(User user) {
        if(user == null) {
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setRoles(user.getRoles());
        userDto.setUserName(user.getUsername());
//        userDto.setTokenValue(user.getToken().getValue());
        return userDto;
    }



}
