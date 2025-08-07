package com.scaler.userservice.dtos.requests;

import com.scaler.userservice.model.Role;
import jakarta.persistence.ManyToMany;

import java.util.List;

public class SignupRequestDto {
    private String name;
    private String username;
    private String email;
    private String password;
    private Integer phoneNumber;

}
