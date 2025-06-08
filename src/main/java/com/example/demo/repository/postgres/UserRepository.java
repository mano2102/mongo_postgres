package com.example.demo.repository.postgres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.postgresmodel.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    
}
