package com.shopesimple.invManager.Service.Auth;

import com.shopesimple.invManager.Exception.UsernameAlreadyExistsException;
import com.shopesimple.invManager.Models.User;

public interface SignupInterface{
    public User signUpUser(String username, String emailId,String password,String fullName) throws UsernameAlreadyExistsException;
}
