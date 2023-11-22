package com.shopesimple.invManager.Repos;

import com.shopesimple.invManager.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdRepo extends JpaRepository<Product,Long> {

}
