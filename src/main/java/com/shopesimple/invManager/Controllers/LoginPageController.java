package com.shopesimple.invManager.Controllers;


import com.shopesimple.invManager.DTO.LoginDtoRequest;
import com.shopesimple.invManager.DTO.LoginDtoResponse;
import com.shopesimple.invManager.Exception.UsernameAlreadyExistsException;
import com.shopesimple.invManager.Models.User;
import com.shopesimple.invManager.Service.LoginPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class LoginPageController {
    private  final LoginPageService loginPageService;
    public LoginPageController(LoginPageService loginPageService) {
        this.loginPageService = loginPageService;
    }
    @PostMapping("/signup")
     public ResponseEntity<LoginDtoResponse> getLoginPage(@RequestBody LoginDtoRequest request) throws UsernameAlreadyExistsException {
        System.out.println("In Controller");
        User user=loginPageService.signUpUser(
                request.getUsername(),
                request.getEmailId(),
                request.getPassword()
                );

        LoginDtoResponse loginDtoResponse = new LoginDtoResponse();
        loginDtoResponse.setEmailId(user.getEmailId());

       return null;
    }

}
