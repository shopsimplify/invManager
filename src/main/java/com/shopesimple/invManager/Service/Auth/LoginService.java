package com.shopesimple.invManager.Service.Auth;

import com.shopesimple.invManager.DTO.UserDto;
import com.shopesimple.invManager.Exception.NoUserExist;
import com.shopesimple.invManager.Exception.WrongPassword;
import com.shopesimple.invManager.Models.User;
import com.shopesimple.invManager.Repos.Auth.LoginRepo;
import com.shopesimple.invManager.ThirdParty.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.util.MultiValueMapAdapter;

import java.util.HashMap;
import java.util.Optional;

@Service
public class LoginService implements LoginInterface{
    private final LoginRepo loginRepo;
    private final PasswordEncoder passwordEncoder;
    private final Jwt jwt;

    @Autowired
    public LoginService(LoginRepo loginRepo, PasswordEncoder passwordEncoder, Jwt jwt) {
        this.loginRepo = loginRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwt = jwt;
    }


    @Override
    public ResponseEntity<UserDto> login(String emailId, String password) throws NoUserExist, WrongPassword {
        Optional<User> optionalUser = loginRepo.findByEmailId(emailId);

        if(optionalUser.isEmpty())
            throw new NoUserExist("User"+emailId+"not in database");

        User user = optionalUser.get();
       if(!bCryptPasswordEncoder.matches(password, user.getPassword()))
           throw new WrongPassword("Type a correct password!!");

        String token =jwt.generateToken(emailId);
        UserDto userDto = UserDto.from(user);

        MultiValueMapAdapter<String,String> headers = new MultiValueMapAdapter<>(new HashMap<>());
           headers.add("AUTH_TOKEN",token);

        ResponseEntity<UserDto> response= new ResponseEntity<>(
                userDto,
                headers,
                HttpStatus.OK
        );
        return response;
    }
}
