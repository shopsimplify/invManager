package com.shopesimple.invManager.Controllers.Auth;
import com.shopesimple.invManager.DTO.AuthDtos.ValidRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class ValidateController {

    @PostMapping("/validate")
    public boolean validateUser(ValidRequestDto validRequestDto){


        return true;
    }
}
