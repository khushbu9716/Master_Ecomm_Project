package com.scaler.productcatalogueecom.client.commons;

import com.scaler.productcatalogueecom.client.dtos.UserDto;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthCommons {

//    @Autowired
    private RestTemplate restTemplate;

    public AuthCommons(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDto validateUser(String token) {
        String url = "http://localhost:8081/auth/validate/" + token;

        ResponseEntity<UserDto> response = restTemplate.getForEntity(url, UserDto.class);
        return response.getBody();
    }

}
