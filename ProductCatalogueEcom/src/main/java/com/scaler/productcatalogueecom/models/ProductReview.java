package com.scaler.productcatalogueecom.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ProductReview extends BaseModel{
    private String email;
    private String comment;
    private Integer ratings;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
