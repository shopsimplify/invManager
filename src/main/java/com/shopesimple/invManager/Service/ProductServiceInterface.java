package com.shopesimple.invManager.Service;

import com.shopesimple.invManager.Models.Product;

import java.util.List;

public interface ProductServiceInterface {
    public void addProd(String prodName, String prodDescription, String category);
    public List<Product> getProducts(String token);
}
