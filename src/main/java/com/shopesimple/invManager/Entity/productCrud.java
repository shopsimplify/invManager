package com.shopesimple.invManager.Entity;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class productCrud {
    @Id
    int productID;
    String productName;

    public productCrud(){}
    public productCrud(int productID,String productName)
    {
        this.productID=productID;
        this.productName=productName;
    } 
}
