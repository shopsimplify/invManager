package com.shopesimple.invManager.Controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginPage {

    @RequestMapping("/login")
    public void getdata() {
        System.out.println("helooooooo");
    }

     void getLoginPage()
    {
        System.out.println("Login page do");

    }

}
