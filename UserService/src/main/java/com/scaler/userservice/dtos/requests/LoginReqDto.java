package com.scaler.userservice.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginReqDto {
    private String email;
    private String password;
}
