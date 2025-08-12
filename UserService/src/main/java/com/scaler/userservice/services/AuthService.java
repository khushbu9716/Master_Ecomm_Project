package com.scaler.userservice.services;

import com.scaler.userservice.dtos.requests.SignupRequestDto;
import com.scaler.userservice.exceptions.InvalidTokenException;
import com.scaler.userservice.exceptions.UserAlreadyPresentException;
import com.scaler.userservice.exceptions.UserNotSignedIn;
import com.scaler.userservice.dtos.reponse.LoginResp;
import com.scaler.userservice.model.Token;
import com.scaler.userservice.model.User;
import com.scaler.userservice.repos.RoleRepo;
import com.scaler.userservice.repos.TokenRepository;
import com.scaler.userservice.repos.UserRepo;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
//import org.apache.commons.lang3.tuple.Pair;
//import javafx.util.Pair;


import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
public class AuthService implements IAuthService{

    @Autowired
    private UserRepo userRepo;
    private RoleRepo roleRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public User  signup(SignupRequestDto user) {
        //service is internal so it will talk in terms of model so we will return User
        Optional<User> email = userRepo.findByEmailEquals(user.getEmail());
        System.out.println("Signup Service "+user.getEmail());
        if(email.isPresent()){
            throw new UserAlreadyPresentException("User Already Present Exception!!");
        }
        User userResp = new User();
        userResp.setEmail(user.getEmail());
        userResp.setName(user.getName());
        userResp.setName(user.getName());
        userResp.setUsername(user.getUsername());
        //Instead of showing row Password we need to store encrypted password
        //we have to create Bean of BcryptPasswordOfEncode
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(); create a bean
//        userResp.setPassword(user.getPassword()); //TODO: Use Bcrypt
        userResp.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userResp.setPhoneNumber(user.getPhoneNumber());
        return userRepo.save(userResp);
    }

    @Override
    public Token login(String email, String password){
        //this should return User and one string token so we can make a pair and return
        Optional<User> userOptional = userRepo.findByEmailEquals(email);
        if(userOptional.isEmpty()){
            throw  new UserNotSignedIn("Please signup first!!");
        }
        if(!bCryptPasswordEncoder.matches(password, userOptional.get().getPassword())){
            throw  new UserNotSignedIn("Wrong password!!");
        }
        //Instead this email should return token and success message
        Token token = new Token();
        token.setUser(userOptional.get());
        token.setValue(RandomStringUtils.randomAlphanumeric(128 ));
        //expiresAt should be set to some time in future
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        Date dateAtexpire = calendar.getTime();
        token.setExpiresAt(dateAtexpire);
        return tokenRepository.save(token);

//        return new LoginResp(userOptional.get(), "token");
//        return null;
    }

    @Override
    public User validateToken(String tokenValue) {
        Optional<Token> tokenFromDB = Optional.ofNullable(tokenRepository.findByValueAndExpiresAtAfter(
                tokenValue, new Date()));
        if (tokenFromDB.isEmpty()) {
            throw new InvalidTokenException("Token is invalid or expired");
        }
        return tokenFromDB.get().getUser();
    }

}
