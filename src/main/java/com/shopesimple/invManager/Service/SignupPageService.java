package com.shopesimple.invManager.Service;


import com.shopesimple.invManager.DTO.AuthDtos.LoginDtoRequest;
import com.shopesimple.invManager.DTO.AuthDtos.LoginDtoResponse;
import com.shopesimple.invManager.Exception.UsernameAlreadyExistsException;
import com.shopesimple.invManager.Models.User;
import com.shopesimple.invManager.Repos.SignupRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SignupPageService {
    private final SignupRepo loginRepo;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public SignupPageService(SignupRepo loginRepo) {
        this.loginRepo = loginRepo;
        this.bCryptPasswordEncoder=new BCryptPasswordEncoder();
    }


    public User signUpUser(String username, String emailId,String password,String fullName) throws UsernameAlreadyExistsException {
        Optional<User> optionalUser = loginRepo.findByEmailId(emailId);
        User user = new User();

//If uer already in the DB then throw an exception**************************************************
        if(optionalUser.isEmpty()) {
            throw new UsernameAlreadyExistsException("User with"+emailId+" already exist");
        }

// If no user in Db then create one***************************************************************************
            user.setUsername(username);
            user.setEmailId(emailId);
            // Hash the password using a secure method (e.g., BCrypt)
            user.setPassword(bCryptPasswordEncoder.encode(password));
            user.setFullName(fullName);

        return loginRepo.save(user);
        }
}


