package com.scaler.userservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(BaseModelEntityListener.class)
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreationTimestamp
    @Column(updatable = false)

    private Date createdAt;
    private State state;

    @UpdateTimestamp
    private Date updatedAt;

    private String createdBy;

}
