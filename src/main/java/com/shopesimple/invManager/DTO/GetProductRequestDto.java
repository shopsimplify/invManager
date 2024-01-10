package com.shopesimple.invManager.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetProductRequestDto {
   private int offset;
   private int numberOfResults;
}
