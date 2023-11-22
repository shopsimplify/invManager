package com.shopesimple.invManager.Controllers.Auth;
import com.shopesimple.invManager.DTO.AuthDtos.SignupDtoRequest;
import com.shopesimple.invManager.DTO.AuthDtos.SignupDtoResponse;
import com.shopesimple.invManager.Exception.UsernameAlreadyExistsException;
import com.shopesimple.invManager.Models.User;
import com.shopesimple.invManager.Service.Auth.SignupPageService;
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

//    create new user if that user not exist in the db ******************************************
    @PostMapping("/signup")
     public ResponseEntity<SignupDtoResponse> signUpUser(@RequestBody SignupDtoRequest request, Resource resource) throws UsernameAlreadyExistsException {
//        System.out.println("In Controller");
//        Call the service for signup
        User user=loginPageService.signUpUser(
                request.getUsername(),
                request.getEmailId(),
                request.getPassword(),
                request.getFullName()
                );
        SignupDtoResponse loginDtoResponse = new SignupDtoResponse();
        loginDtoResponse.setEmailId(user.getEmailId());

//Return the mail id is register on Db********************************************
        return new ResponseEntity<>(loginDtoResponse,HttpStatus.CREATED);
    }

}
