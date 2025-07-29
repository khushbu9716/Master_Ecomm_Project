package com.scaler.productcatalogueecom.services;

import com.scaler.productcatalogueecom.dto.request.CreateProductDto;
import com.scaler.productcatalogueecom.exceptions.ProductNotFoundException;
import com.scaler.productcatalogueecom.models.Category;
import com.scaler.productcatalogueecom.models.Product;
import com.scaler.productcatalogueecom.repos.CategoryRepository;
import com.scaler.productcatalogueecom.repos.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl  implements ProductService {
    @Autowired
    ProductRepository productRepository;
    private  ModelMapper modelMapper;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Product createProduct(CreateProductDto requestDto) {
        System.out.println("Creating product");
//        Category category =
        // Convert DTO to Entity
        Product product = modelMapper.map(requestDto, Product.class);
        Category category = categoryRepository.findById(requestDto.getCategoryId())
                .orElseThrow(()-> new ProductNotFoundException(requestDto.getCategoryId()));
        product.setCategory(category);
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        System.out.println("Getting all products");
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(String id, Product product) {
        Product prd = productRepository.findById(id)
                .map(existingprod ->{
                    existingprod.setId(product.getId());
                    existingprod.setCategory(product.getCategory());
                    existingprod.setTitle(product.getTitle());
                    existingprod.setDescription(product.getDescription());
                    existingprod.setPrice(product.getPrice());
                    existingprod.setReviews(product.getReviews());
                    productRepository.save(existingprod);
                    return existingprod;
                }).orElseThrow(()->new ProductNotFoundException("Product not found"+ id));
        return prd;
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
        //if Id is not there still no error or anything is it correct?


    }

    @Override
    public Product getProductById(String id) {
        return productRepository.findById(id)
                .orElseThrow(()->new ProductNotFoundException("Product not found "));
    }


}
