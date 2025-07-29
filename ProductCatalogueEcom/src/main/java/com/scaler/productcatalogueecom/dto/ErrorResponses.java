package com.scaler.productcatalogueecom.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorResponses {
    private LocalDateTime timestamp;
    private int status;
    private String message;
    private String error;
    private String path;

}
