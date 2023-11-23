package com.shopesimple.invManager.Service.Auth;

import com.shopesimple.invManager.DTO.UserDto;
import com.shopesimple.invManager.Exception.NoUserExist;
import com.shopesimple.invManager.Exception.WrongPassword;
import com.shopesimple.invManager.Models.User;
import org.springframework.http.ResponseEntity;

public interface LoginInterface {
    public ResponseEntity<String> login(String emailId, String password) throws NoUserExist, WrongPassword;
}
