package com.shopesimple.invManager.Service;
import com.shopesimple.invManager.DTO.ProductListDto;
import com.shopesimple.invManager.Models.Product;
import com.shopesimple.invManager.Repos.ProdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdService implements ProductServiceInterface{
    private final ProdRepo prodRepo;

    @Autowired
    public ProdService(ProdRepo prodRepo) {
        this.prodRepo = prodRepo;
    }

    public void addProd(String prodName, String prodDescription, String category){
        Product product = new Product();
        product.setProdName(prodName);
        product.setDescription(prodDescription);
        product.setCategory(category);

        prodRepo.save(product);
    }

    @Override
    public List<ProductListDto> getProducts() {
        List<Product> productList = prodRepo.findAll();
        ProductListDto productListDto = new ProductListDto();
        List<ProductListDto> productListDtos = new ArrayList<>();

        for(Product product:productList){
            productListDto.setProdName(product.getProdName());
            productListDto.setDescription(product.getDescription());
            productListDto.setCategory(product.getCategory());
            productListDtos.add(productListDto);
        }
        return productListDtos;
    }



}