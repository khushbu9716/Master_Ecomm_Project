package com.scaler.productcatalogueecom.repos;

import com.scaler.productcatalogueecom.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {}

