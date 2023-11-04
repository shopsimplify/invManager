package com.shopesimple.invManager.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.springframework.data.annotation.Id;



@Getter
@Setter
@Entity
@NoArgsConstructor
public class User extends BaseModel{
    @NotNull
    @Column(unique = true)
    private String username;
    @NotNull
    @Column(unique = true)
    private String emailId;
    @NotNull
    private String password;
    
    public User(String username,String emailId, String password) {
        this.username = username;
        this.password = password;
        this.emailId = emailId;
    }
}
