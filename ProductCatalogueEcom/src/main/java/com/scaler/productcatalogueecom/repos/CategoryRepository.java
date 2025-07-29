package com.scaler.productcatalogueecom.repos;

import com.scaler.productcatalogueecom.models.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
}
