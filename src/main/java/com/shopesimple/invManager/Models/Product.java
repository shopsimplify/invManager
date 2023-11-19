package com.shopesimple.invManager.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String prodName;
    private String Description;
    private Category category;

}
