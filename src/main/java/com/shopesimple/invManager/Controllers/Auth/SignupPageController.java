package com.shopesimple.invManager.Controllers.Auth;
import com.shopesimple.invManager.DTO.AuthDtos.LoginDtoRequest;
import com.shopesimple.invManager.DTO.AuthDtos.LoginDtoResponse;
import com.shopesimple.invManager.Exception.UsernameAlreadyExistsException;
import com.shopesimple.invManager.Models.User;
import com.shopesimple.invManager.Service.SignupPageService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class SignupPageController {
    private  final SignupPageService loginPageService;
    public SignupPageController(SignupPageService loginPageService) {
        this.loginPageService = loginPageService;
    }

    @PostMapping("/signup")
     public ResponseEntity<LoginDtoResponse> signUpUser(@RequestBody LoginDtoRequest request, Resource resource) throws UsernameAlreadyExistsException {
//        System.out.println("In Controller");
//        Call the service for signup
        User user=loginPageService.signUpUser(
                request.getUsername(),
                request.getEmailId(),
                request.getPassword(),
                request.getFullName()
                );
        LoginDtoResponse loginDtoResponse = new LoginDtoResponse();
        loginDtoResponse.setEmailId(user.getEmailId());

//Return the mail id is register on Db********************************************
        return new ResponseEntity<>(loginDtoResponse,HttpStatus.CREATED);
    }

}
