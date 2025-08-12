package com.scaler.userservice.repos;

import com.scaler.userservice.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface  TokenRepository extends JpaRepository<Token, Long> {

    @Override
    Token save(Token token);

    //select * from tokens where value = ?1 && expiresAt > now()
//    Token findByValueAfterAndExpiresAtAfter(String value, Date currentDate);
    Token findByValueAndExpiresAtAfter(String value, Date currentDate);
    //(This matches value and expiresAt fields in Token.)
//    Token findByValueAndExpiresAtAfter(String tokenValue, Date date);
}
