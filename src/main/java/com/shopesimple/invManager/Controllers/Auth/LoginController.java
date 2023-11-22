package com.shopesimple.invManager.Controllers.Auth;

import com.shopesimple.invManager.DTO.AuthDtos.LoginRequestDto;
import com.shopesimple.invManager.DTO.AuthDtos.LoginResponseDto;
import com.shopesimple.invManager.Models.User;
import com.shopesimple.invManager.Service.Auth.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class LoginController {
  private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public LoginResponseDto loginUser(LoginRequestDto loginRequestDto){
        String emailId=loginRequestDto.getEmailId();
        String password = loginRequestDto.getPassword();

        loginService.login(emailId,password);
        return null;
    }
}
