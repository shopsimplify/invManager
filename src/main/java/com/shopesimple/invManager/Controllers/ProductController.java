package com.shopesimple.invManager.Controllers;
import com.shopesimple.invManager.DTO.ProductRequestDto;
import com.shopesimple.invManager.DTO.ProductResponseDto;
import com.shopesimple.invManager.Models.Product;
import com.shopesimple.invManager.Service.ProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashboard/product")
public class ProductController {
    private final ProdService prodService;

    @Autowired
    public ProductController(ProdService prodService) {
        this.prodService = prodService;
    }

//    add product in db ***********************************************************************
    @PostMapping ("/add")
    public ProductResponseDto addProduct(@RequestBody ProductRequestDto productRequestDto){
        String prodName = productRequestDto.getProdName();
        String prodDescription = productRequestDto.getDescription();
        String category = productRequestDto.getCategory();
          prodService.addProd(prodName,prodDescription,category);

          ProductResponseDto productResponseDto = new ProductResponseDto();
          productResponseDto.setProdName(prodName);

        return productResponseDto;
    }


    @GetMapping("/get_products")
    public ResponseEntity<List<Product>> getAllProduct(@RequestHeader("AUTH_TOKEN") String token){
     List<Product> productList = prodService.getProducts(token);
  return null;
    }
}