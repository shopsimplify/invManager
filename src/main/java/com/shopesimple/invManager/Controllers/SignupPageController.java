package com.shopesimple.invManager.Controllers;
import com.shopesimple.invManager.DTO.LoginDtoRequest;
import com.shopesimple.invManager.DTO.LoginDtoResponse;
import com.shopesimple.invManager.Exception.UsernameAlreadyExistsException;
import com.shopesimple.invManager.Models.User;
import com.shopesimple.invManager.Service.SignupPageService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupPageController {
    private  final SignupPageService loginPageService;
    public SignupPageController(SignupPageService loginPageService) {
        this.loginPageService = loginPageService;
    }
    @PostMapping("/signup")
     public ResponseEntity<LoginDtoResponse> getLoginPage(@RequestBody LoginDtoRequest request,Resource resource) throws UsernameAlreadyExistsException {
        System.out.println("In Controller");
        User user=loginPageService.signUpUser(
                request.getUsername(),
                request.getEmailId(),
                request.getPassword()
                );

        LoginDtoResponse loginDtoResponse = new LoginDtoResponse();
        loginDtoResponse.setEmailId(user.getEmailId());


       return new ResponseEntity<>(loginDtoResponse,HttpStatus.CREATED);
    }

}
