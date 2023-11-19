package com.shopesimple.invManager.Service;


import com.shopesimple.invManager.Models.Product;
import com.shopesimple.invManager.Repos.ProdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdService {

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

}
