package com.shopesimple.invManager.Controllers;
import com.shopesimple.invManager.DTO.ProductListDto;
import com.shopesimple.invManager.DTO.ProductRequestDto;
import com.shopesimple.invManager.DTO.ProductResponseDto;
import com.shopesimple.invManager.DTO.ValidateTokenResponseDto;
import com.shopesimple.invManager.DTO.SessionStatus;
import com.shopesimple.invManager.Service.ProdService;
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
    private final ProdService prodService;
   private final AuthClient authClient;

    @Autowired
    public ProductController(ProdService prodService, AuthClient authClient) {
        this.prodService = prodService;
        this.authClient = authClient;
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
    public ResponseEntity<List<ProductListDto>> getAllProd(@Nullable @RequestHeader("AUTH_TOKEN")String token){
//         Checking token in DB ************************************
           if(token==null)
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//Checking token is valid **********************************************
        ValidateTokenResponseDto response = authClient.valid(token);
            if(response.getSessionStatus().equals(SessionStatus.INVALID))
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

// Checking the user have the permissions ********************************

        List<ProductListDto> productList = prodService.getProducts();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}