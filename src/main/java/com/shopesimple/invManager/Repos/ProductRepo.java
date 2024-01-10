package com.shopesimple.invManager.Repos;

import com.shopesimple.invManager.Models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    Optional<Product> findById(Long prodId);
//    Pending work******************
    @Override
    Page<Product> findAll(Pageable pageable);
}
