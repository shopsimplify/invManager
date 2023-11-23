package com.shopesimple.invManager.Service.Auth;
import com.shopesimple.invManager.Exception.UsernameAlreadyExistsException;
import com.shopesimple.invManager.Models.User;
import com.shopesimple.invManager.Repos.Auth.SignupRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SignupService implements SignupInterface{
    private final SignupRepo loginRepo;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public SignupService(SignupRepo loginRepo) {
        this.loginRepo = loginRepo;
        this.bCryptPasswordEncoder=new BCryptPasswordEncoder();
    }


    public User signUpUser(String username, String emailId,String password,String fullName) throws UsernameAlreadyExistsException {
        Optional<User> optionalUser = loginRepo.findByEmailId(emailId);
        User user = new User();

//If uer already in the DB then throw an exception**************************************************
        if(optionalUser.isPresent()) {
            throw new UsernameAlreadyExistsException("User with "+emailId+" already exist");
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


