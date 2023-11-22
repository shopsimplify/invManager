package com.shopesimple.invManager.Service.Auth;

import com.shopesimple.invManager.Repos.Auth.ValidateRepo;
import org.springframework.stereotype.Service;

@Service
public class ValidateService implements ValidateInterface{
    private final ValidateRepo validateRepo;

    public ValidateService(ValidateRepo validateRepo) {
        this.validateRepo = validateRepo;
    }

    @Override
    public boolean valid(String password) {

        return false;
    }
}
