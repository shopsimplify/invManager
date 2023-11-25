package com.shopesimple.invManager.Controllers.Auth;

import com.shopesimple.invManager.DTO.AuthDtos.LoginRequestDto;
import com.shopesimple.invManager.DTO.AuthDtos.LoginResponseDto;
import com.shopesimple.invManager.DTO.UserDto;
import com.shopesimple.invManager.Exception.NoUserExist;
import com.shopesimple.invManager.Exception.WrongPassword;
import com.shopesimple.invManager.Models.User;
import com.shopesimple.invManager.Service.Auth.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class LoginController {
  private final LoginService loginService;

  @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> loginUser(@RequestBody LoginRequestDto request) throws NoUserExist, WrongPassword {
       return loginService.login(request.getEmailId(),request.getPassword());
    }
}
