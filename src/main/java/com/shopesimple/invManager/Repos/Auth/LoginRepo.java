package com.shopesimple.invManager.Repos.Auth;

import com.shopesimple.invManager.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepo extends JpaRepository<User,Long> {
    Optional<User> findByEmailId(String emailId);
}
