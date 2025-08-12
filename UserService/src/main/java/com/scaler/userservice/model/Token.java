package com.scaler.userservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@Entity
public class Token extends BaseModel {
    private String value;
    private Date expiresAt;

    //There should be some reation between user and token
    @ManyToOne
    private User user;
    //1 user can have many token means they can have many login options

}
