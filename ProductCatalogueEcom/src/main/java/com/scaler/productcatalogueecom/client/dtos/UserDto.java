package com.scaler.productcatalogueecom.client.dtos;

//import com.scaler.userservice.model.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private long id;
    private String userName;
    private String email;
//    private List<Role> roles;
    private String tokenValue; // Optional, if you want to include the token in the user DTO

}
