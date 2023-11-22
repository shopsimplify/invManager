package com.shopesimple.invManager.Controllers.Auth;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class Validate {

    @PostMapping("/validate")
    public boolean validateUser(){
        return true;
    }
}
