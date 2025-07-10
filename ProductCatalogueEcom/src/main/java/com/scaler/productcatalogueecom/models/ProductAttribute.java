package com.scaler.productcatalogueecom.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ProductAttribute extends BaseModel {
    private String keyName;
    private String value;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


}
