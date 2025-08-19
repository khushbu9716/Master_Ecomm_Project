package com.scaler.userservice.model;

import jakarta.persistence.PrePersist;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class BaseModelEntityListener {
//    @PrePersist
//    public void prePersist(BaseModel baseModel) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null) {
//            baseModel.setCreatedBy(authentication.getName());
//        }
//    }
    @PrePersist
    public void prePersist(BaseModel baseModel) {
        if (baseModel.getCreatedBy() == null) { // Only set if not already set
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String username = (auth != null && !(auth instanceof AnonymousAuthenticationToken))
                    ? auth.getName()
                    : "system"; // Default for signups
            baseModel.setCreatedBy(username);
        }
    }
}
