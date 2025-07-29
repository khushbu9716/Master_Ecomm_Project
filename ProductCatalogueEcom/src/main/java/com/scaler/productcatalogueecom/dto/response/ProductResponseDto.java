package com.scaler.productcatalogueecom.dto.response;

import com.scaler.productcatalogueecom.models.Category;
import com.scaler.productcatalogueecom.models.ProductAttribute;
import com.scaler.productcatalogueecom.models.ProductImage;
import com.scaler.productcatalogueecom.models.ProductReview;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductResponseDto {

    private String productId;
    private String title;
    private String description;
    private BigDecimal price;
    private Integer stockQuantity;
    private String specs;

    private String categoryName;
    private List<ProductAttribute> attributeList;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

//    private List<ProductImage> productImages = new ArrayList<>();
//    private List<ProductReview> reviews = new ArrayList<>();
}
