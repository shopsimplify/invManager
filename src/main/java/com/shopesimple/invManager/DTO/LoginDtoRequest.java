package com.shopesimple.invManager.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDtoRequest {
    private String username;
    private String emailId;
    private String password;
}
