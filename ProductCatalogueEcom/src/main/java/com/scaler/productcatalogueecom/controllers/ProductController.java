package com.scaler.productcatalogueecom.controllers;

import com.scaler.productcatalogueecom.models.Product;
import com.scaler.productcatalogueecom.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        System.out.println("Create Product");
        return productRepository.save(product);
    }
    //Controller-> Service -> Repo

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

}
