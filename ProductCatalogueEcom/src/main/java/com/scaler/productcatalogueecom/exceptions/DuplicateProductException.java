package com.scaler.productcatalogueecom.exceptions;

public class DuplicateProductException extends Exception {
    public DuplicateProductException(String id) {
        super("Duplicate Product with id: "+id);
    }
}
