package com.shopesimple.invManager.DTO.AuthDtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDto {
    private String emailId;
    private String password;
}
