package com.scaler.userservice.dtos;

import com.scaler.userservice.model.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private long id;
    private String userName;
    private String email;
    private List<Role> roles;

}
