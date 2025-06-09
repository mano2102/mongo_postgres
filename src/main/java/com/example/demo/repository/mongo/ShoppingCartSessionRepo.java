package com.example.demo.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartSessionRepo  extends MongoRepository<ShoppingCartSessionRepo,String>{
    
}
