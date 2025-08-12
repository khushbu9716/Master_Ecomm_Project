package com.scaler.userservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class User extends BaseModel{
    //name, email, password, phone no
    private String name;
    private String username;
    private String email;
    private String password;
    private Long phoneNumber;
    @ManyToMany
    private List<Role> roles;
    //Role would be a list-> becs one person can be a TA, Student and Mentor also
}
/****
 *  USer : role -> m:m
 * */