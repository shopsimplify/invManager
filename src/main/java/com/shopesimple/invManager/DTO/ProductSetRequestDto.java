package com.shopesimple.invManager.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductSetRequestDto {
    private Long id;
    private String prodName;
    private String description;
    private String category;
}
