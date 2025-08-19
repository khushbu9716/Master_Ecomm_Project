package com.scaler.productcatalogueecom.controllers;

import com.scaler.productcatalogueecom.client.commons.AuthCommons;
import com.scaler.productcatalogueecom.client.dtos.UserDto;
import com.scaler.productcatalogueecom.dto.request.CreateProductDto;
import com.scaler.productcatalogueecom.exceptions.DuplicateProductException;
import com.scaler.productcatalogueecom.exceptions.InvalidProductDataException;
import com.scaler.productcatalogueecom.exceptions.UnAuthorizedException;
import com.scaler.productcatalogueecom.models.Product;
import com.scaler.productcatalogueecom.repos.ProductRepository;
import com.scaler.productcatalogueecom.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
//    private ProductRepository productRepository;
    private ProductService productService;

    @Autowired
    private AuthCommons authCommons;

    @PostMapping
    public ResponseEntity<Product> createProduct(
            @Valid @RequestBody CreateProductDto productRequestDto){
        //DOUBT
//        System.out.println("Create Product");
//        try{
//            Product product = productService.createProduct(productRequestDto);
//            return ResponseEntity.status(HttpStatus.CREATED).body(product);
//
//        }catch(InvalidProductDataException | DuplicateProductException e){
////            e.printStackTrace();
//            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
//        }
        Product product = productService.createProduct(productRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
    //Controller-> Service -> Repo

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct( @PathVariable String id ,
                                                  @RequestBody Product product){
        System.out.println("Update Product");
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        System.out.println("Delete Product");
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/{token}")
    public ResponseEntity<Product> getProductById(@PathVariable String id,
                                                  @PathVariable String token) {
        System.out.println("Get Product");
        UserDto userDto = authCommons.validateUser(token);
        if (userDto == null) {
            throw new UnAuthorizedException("Invalid token provided");
        }
        return ResponseEntity.ok(productService.getProductById(id));
    }

}
