package com.scaler.productcatalogueecom.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductImage extends BaseModel{
    private String url;
    private String altText;

}
