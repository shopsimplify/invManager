package com.shopesimple.invManager.Service;
import com.shopesimple.invManager.DTO.ProductListDto;
import com.shopesimple.invManager.DTO.ProductSetResponseDto;
import com.shopesimple.invManager.Exception.NoProductExist;
import com.shopesimple.invManager.Models.Product;
import com.shopesimple.invManager.Repos.ProductRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductServiceInterface{
    private final ProductRepo productRepo;
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
    public List<ProductListDto> getAllProd() {
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

    public ProductSetResponseDto findProduct(Long prodId) throws NoProductExist {
        Optional<Product> productOptional = productRepo.findById(prodId);

if(productOptional.isEmpty())
    throw new NoProductExist("No such id in store");

        Product product = productOptional.get();
        ProductSetResponseDto productResponseDto = new ProductSetResponseDto();
        productResponseDto.setProdName(product.getProdName());
        productResponseDto.setCategory(product.getCategory());
        productResponseDto.setDescription(product.getDescription());
        return productResponseDto;
}

    public Page<Product> getProducts(int numberOfProducts,int offset){
        Page<Product> products = productRepo.findAll(
                PageRequest.of(offset/numberOfProducts,numberOfProducts)
        );
        return  products;
    }

}