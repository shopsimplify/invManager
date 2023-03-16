package com.shopesimple.invManager.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.shopesimple.invManager.Entity.productCrud;
import com.shopesimple.invManager.Repos.crudDaoProd;

public class productService {
    @Autowired
    private crudDaoProd repo;


    public List<productCrud> allProducts(){
        return this.repo.findAll();
    }
}
