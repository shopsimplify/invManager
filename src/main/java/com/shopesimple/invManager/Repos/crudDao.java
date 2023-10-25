package com.shopesimple.invManager.Repos;

import com.shopesimple.invManager.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface crudDao extends JpaRepository<User,Long> {


    
} 
