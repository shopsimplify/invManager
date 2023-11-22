package com.shopesimple.invManager.Repos.Auth;

import com.shopesimple.invManager.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ValidateRepo extends JpaRepository<User,Long> {

}
