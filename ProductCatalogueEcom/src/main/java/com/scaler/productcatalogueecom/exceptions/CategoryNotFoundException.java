package com.scaler.productcatalogueecom.exceptions;

public class CategoryNotFoundException extends Exception {
    public CategoryNotFoundException(String id) {
        super("Category Not Found with id: "+id);
    }
}
