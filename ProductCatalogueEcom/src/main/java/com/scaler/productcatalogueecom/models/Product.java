package com.scaler.productcatalogueecom.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

@Entity
public class Product extends BaseModel {
    private  String title;
    private  String description;
    private  BigDecimal price;
//    private  String image;
    private Integer stockQuantity;
    private String specs;

    @ManyToOne
    @JoinColumn(name = "category_id")
    //@JoinColumn specifies the foreign key column name in the product table
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductAttribute> attributeList = new ArrayList<>();


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductImage> productImages = new ArrayList<>();
//
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductReview> reviews = new ArrayList<>();


}
