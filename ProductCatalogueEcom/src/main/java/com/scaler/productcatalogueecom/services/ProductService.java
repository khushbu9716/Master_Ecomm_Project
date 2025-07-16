package com.scaler.productcatalogueecom.services;

import com.scaler.productcatalogueecom.models.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    List<Product> getAllProducts();
}
