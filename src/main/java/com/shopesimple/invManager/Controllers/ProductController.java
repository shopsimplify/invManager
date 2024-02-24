package com.shopesimple.invManager.Controllers;
import com.shopesimple.invManager.DTO.*;
import com.shopesimple.invManager.Exception.NoProductExist;
import com.shopesimple.invManager.Models.Product;
import com.shopesimple.invManager.Service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/dashboard/product")
public class ProductController {
    private final ProductService prodService;

    public ProductController(ProductService prodService) {
        this.prodService = prodService;
        }

//    add product in db ***********************************************************************
    @PostMapping ("/add")
    public ProductSetResponseDto addProduct(@RequestBody ProductSetRequestDto productRequestDto){
        String prodName = productRequestDto.getProdName();
        String prodDescription = productRequestDto.getDescription();
        String category = productRequestDto.getCategory();
          prodService.addProd(prodName,prodDescription,category);

          ProductSetResponseDto productResponseDto = new ProductSetResponseDto();
          productResponseDto.setProdName(prodName);
          productResponseDto.setCategory(category);
          productResponseDto.setDescription(prodDescription);
        return productResponseDto;
    }
//Fetch all products from DB ********************************************************************
    @GetMapping("/get_products")
    public ResponseEntity<List<ProductListDto>> getAllProd(){

        List<ProductListDto> productList = prodService.getAllProd();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/find_product/{prodId}")
    public ResponseEntity<ProductSetResponseDto> findProduct(@PathVariable Long prodId) throws NoProductExist {
        ProductSetResponseDto productResponseDto = prodService.findProduct(prodId);
        return new ResponseEntity<>(productResponseDto,HttpStatus.OK);
    }


    @GetMapping("/page_products")
    public ResponseEntity<Page<Product>> getProducts(@RequestBody GetProductRequestDto request){
        return ResponseEntity.of(Optional.ofNullable(prodService.getProducts(request.getNumberOfResults(), request.getOffset())));
    }
}