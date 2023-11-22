package com.shopesimple.invManager.DTO.AuthDtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDtoRequest {
    private String fullName;
    private String username;
    private String emailId;
    private String password;
}
