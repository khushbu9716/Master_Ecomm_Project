package com.scaler.productcatalogueecom.services;

import com.scaler.productcatalogueecom.dto.request.CreateProductDto;
import com.scaler.productcatalogueecom.models.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(CreateProductDto product);
    List<Product> getAllProducts();
    Product updateProduct(String id, Product product);
    void deleteProduct(String id);
    Product getProductById(String id);
}
