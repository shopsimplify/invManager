package com.shopesimple.invManager.Controllers;


import com.shopesimple.invManager.DTO.LoginDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginPage {
    @RequestMapping("/login")
    public void getdata() {
        System.out.println("helooooooo");
    }

    @PostMapping("/signup")
     public void getLoginPage(LoginDto request)
    {

    }

}
