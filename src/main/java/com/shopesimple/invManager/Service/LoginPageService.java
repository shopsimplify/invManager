package com.shopesimple.invManager.Service;


import com.shopesimple.invManager.DTO.LoginDtoRequest;
import com.shopesimple.invManager.Exception.UsernameAlreadyExistsException;
import com.shopesimple.invManager.Models.User;
import com.shopesimple.invManager.Repos.LoginRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginPageService {
    private final LoginRepo loginRepo;

    public LoginPageService(LoginRepo loginRepo) {
        this.loginRepo = loginRepo;
    }





    public User signUpUser(String username, String emailId,String password) throws UsernameAlreadyExistsException {
        User user = new User();
        Optional<User> optionalUser = loginRepo.findByEmailId(emailId);

        System.out.println("In service");
        if(optionalUser.equals(emailId))
            throw new UsernameAlreadyExistsException("User already exist");

       else {
            user.setUsername(username);
            user.setEmailId(emailId);
            // Hash the password using a secure method (e.g., BCrypt)
            user.setPassword(password);

            return loginRepo.save(user);
        }
}

}
