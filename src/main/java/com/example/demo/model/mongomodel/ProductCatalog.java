package com.example.demo.model.mongomodel;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "product_catalog")
public class ProductCatalog {

    @Id
    private String id;

    private String productId;  // MySQL product ID reference

    private Map<String, Object> attributes; // flexible key-values for product specs

    private List<String> tags;

    private List<String> images; // URLs or paths
}
