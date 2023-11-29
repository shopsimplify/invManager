package com.shopesimple.invManager.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidTokenRequestDto {
    private String token;
    private Long userId;
}
