package com.shopesimple.invManager.Controllers;
import com.shopesimple.invManager.DTO.*;
import com.shopesimple.invManager.Service.ProductService;
import com.shopesimple.invManager.ThirdParty.Security.AuthClient;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashboard/product")
public class ProductController {
    private final ProductService prodService;
    @Autowired
    public ProductController(ProductService prodService) {
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
//Fetch all products from DB ********************************************************************
    @GetMapping("/get_products")
    public ResponseEntity<List<ProductListDto>> getAllProd(){

        List<ProductListDto> productList = prodService.getProducts();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}