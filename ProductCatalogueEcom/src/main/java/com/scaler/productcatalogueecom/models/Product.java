package com.scaler.productcatalogueecom.models;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;


@Getter
@Setter


@Document(collection = "products")
public class Product extends BaseModel {
    private String title;
    private String description;
    private BigDecimal price;
    private Integer stockQuantity;
    private String specs;

    @DBRef
    private Category category;
    //1:1category
//    private List<Category> categoryList = new ArrayList<>();
    private List<ProductAttribute> attributeList = new ArrayList<>();
    private List<ProductImage> productImages = new ArrayList<>();
    private List<ProductReview> reviews = new ArrayList<>();
}

