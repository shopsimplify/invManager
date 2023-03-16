package com.shopesimple.invManager.Repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shopesimple.invManager.Entity.users;

public interface crudDaoUser extends MongoRepository<users,String> {
    // public List<users> findAll();
    
   
       
} 
