package com.example.demo.model.mongomodel;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "customer_reviews")
public class CustomerReview {

    @Id
    private String id;

    private String productId;  // reference to MySQL product

    private String customerId;  // or customerName if you prefer

    private int rating;

    private String reviewText;

    private LocalDateTime reviewDate;
}
