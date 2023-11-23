package com.shopesimple.invManager.Service.Auth;

import com.shopesimple.invManager.DTO.UserDto;
import com.shopesimple.invManager.Exception.NoUserExist;
import com.shopesimple.invManager.Exception.WrongPassword;
import com.shopesimple.invManager.Models.User;
import com.shopesimple.invManager.Repos.Auth.LoginRepo;
import com.shopesimple.invManager.ThirdParty.Jwt;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService implements LoginInterface{
    private final LoginRepo loginRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final Jwt jwt;

    public LoginService(LoginRepo loginRepo, BCryptPasswordEncoder bCryptPasswordEncoder, Jwt jwt) {
        this.loginRepo = loginRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.jwt = jwt;
    }


    @Override
    public ResponseEntity<String> login(String emailId, String password) throws NoUserExist, WrongPassword {
        Optional<User> optionalUser = loginRepo.findByEmailId(emailId);

        if(optionalUser.isEmpty())
            throw new NoUserExist("User"+emailId+"not in database");

        User user = optionalUser.get();
       if(!bCryptPasswordEncoder.matches(password, user.getPassword()))
           throw new WrongPassword("Type a correct password!!");



        return new ResponseEntity<>(jwt.generateToken(emailId), HttpStatus.OK);
    }
}
