package com.shopesimple.invManager.DTO;

import com.shopesimple.invManager.Models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDto {
    private Long id;
    private String prodName;
    private String description;
    private String category;
}
