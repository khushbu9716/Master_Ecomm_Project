package com.scaler.productcatalogueecom.services;

import com.scaler.productcatalogueecom.models.Product;
import com.scaler.productcatalogueecom.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl  implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        System.out.println("Creating product");
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
