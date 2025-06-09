package com.example.demo.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.mongomodel.UserActivityLog;

@Repository
public interface UserActivityLogRepo extends MongoRepository<UserActivityLog,String> {
    
}
