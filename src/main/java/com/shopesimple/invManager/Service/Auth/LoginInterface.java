package com.shopesimple.invManager.Service.Auth;

import com.shopesimple.invManager.Models.User;

public interface LoginInterface {
    public User login(String emailId,String password);
}
