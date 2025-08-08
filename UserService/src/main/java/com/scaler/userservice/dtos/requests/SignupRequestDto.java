package com.scaler.userservice.dtos.requests;

import com.scaler.userservice.model.Role;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SignupRequestDto {
    private String name;
    private String username;
    private String email;
    private String password;
    private Integer phoneNumber;

}
