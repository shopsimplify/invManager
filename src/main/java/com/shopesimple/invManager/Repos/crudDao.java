package com.shopesimple.invManager.Repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shopesimple.invManager.Models.users;

public interface crudDao extends MongoRepository<users,String> {


    
} 
