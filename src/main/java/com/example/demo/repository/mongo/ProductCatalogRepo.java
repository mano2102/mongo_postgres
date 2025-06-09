package com.example.demo.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.mongomodel.ProductCatalog;

@Repository
public interface ProductCatalogRepo extends MongoRepository<ProductCatalog, String> {
    
}
