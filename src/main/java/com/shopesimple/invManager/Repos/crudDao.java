package com.shopesimple.invManager.Repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shopesimple.invManager.Models.users;

@Repository
public interface crudDao extends MongoRepository<users,String> {
    
  
       
} 
