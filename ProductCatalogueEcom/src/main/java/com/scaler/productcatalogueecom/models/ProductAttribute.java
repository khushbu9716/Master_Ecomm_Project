package com.scaler.productcatalogueecom.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductAttribute extends BaseModel {
    private String keyName;   // Example: "Processor"
    private String value;     // Example: "A17 Bionic"

    // Constructors
    public ProductAttribute() {}
    public ProductAttribute(String keyName, String value) {
        this.keyName = keyName;
        this.value = value;
    }
}
