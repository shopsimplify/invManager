package com.shopesimple.invManager.Repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shopesimple.invManager.Entity.productCrud;

public interface crudDaoProd extends MongoRepository<productCrud,Integer>{
    
}
