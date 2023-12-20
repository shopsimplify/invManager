package com.shopesimple.invManager.Service;
import com.shopesimple.invManager.DTO.ProductListDto;
import com.shopesimple.invManager.DTO.ProductResponseDto;
import com.shopesimple.invManager.Models.Product;
import com.shopesimple.invManager.Repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductServiceInterface{
    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo prodRepo) {
        this.productRepo = prodRepo;
    }

    public void addProd(String prodName, String prodDescription, String category){
        Product product = new Product();
        product.setProdName(prodName);
        product.setDescription(prodDescription);
        product.setCategory(category);

        productRepo.save(product);
    }

    @Override
    public List<ProductListDto> getProducts() {
        List<Product> productList = productRepo.findAll();
        ProductListDto productListDto ;
        List<ProductListDto> productListDtos = new ArrayList<>();

        for(Product product:productList){
            productListDto = new ProductListDto();
            productListDto.setProdName(product.getProdName());
            productListDto.setDescription(product.getDescription());
            productListDto.setCategory(product.getCategory());
            productListDtos.add(productListDto);
        }
        return productListDtos;
    }

public ProductResponseDto findProduct(Long prodId){
        Optional<Product> productOptional = productRepo.findById(prodId);
        Product product = productOptional.get();
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(product.getId());
        productResponseDto.setProdName(product.getProdName());
        productResponseDto.setCategory(product.getCategory());
        productResponseDto.setDescription(product.getDescription());
        return productResponseDto;
}

}