package com.shopesimple.invManager.Service;

import com.shopesimple.invManager.DTO.ProductListDto;

import java.util.List;

public interface ProductServiceInterface {
    public void addProd(String prodName, String prodDescription, String category);
    public List<ProductListDto> getAllProd();
}
