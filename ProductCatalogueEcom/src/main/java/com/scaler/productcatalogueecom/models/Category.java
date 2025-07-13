package com.scaler.productcatalogueecom.models;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter


@Document(collection = "categories")
public class Category extends BaseModel {
    private String categoryName;
}
