package com.scaler.productcatalogueecom.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import java.util.Date;

@Getter
@Setter
public abstract class BaseModel {
    @Id
    private String id;

    private Date createdAt;
    private Date lastModifiedAt;

    // Getters/setters
}


