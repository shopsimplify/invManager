package com.shopesimple.invManager.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString    

@Document("userlist")
public class users {
    @Id
    String username;
    String password;
// ***************************************************************************************************
     public users(){}

     public users(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
