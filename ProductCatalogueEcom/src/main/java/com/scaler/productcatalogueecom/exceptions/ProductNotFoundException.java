package com.scaler.productcatalogueecom.exceptions;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException( String id){
        super("Product Not Found with id: "+id);
    }
}
