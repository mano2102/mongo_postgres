package com.example.demo.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.mongomodel.CustomerReview;
@Repository
public interface CustomerReviewRepo extends MongoRepository<CustomerReview, String> {
    
}
