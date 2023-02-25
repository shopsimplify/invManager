package com.shopesimple.invManager.Controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.shopesimple.invManager.Models.users;
import com.shopesimple.invManager.Repos.crudDao;


@RestController
public class crudController {
    @Autowired
    private crudDao repo;

    // For add user**************************************************
    @PostMapping("/addUser")
    public String addUser(@RequestBody users user){
        repo.save(user);
        return "user added!!";
    }

// For fetch all users****************************************************
    @GetMapping("/allUsers")
    public List<users> userList(){
        return repo.findAll();
    }

// For user find*******************************************************
     @GetMapping("/userFind/{username}")
    public Optional<users> userFind(@PathVariable String username){
       return repo.findById(username);
    }
//For update users *********************************************pending
@PutMapping("/updateUser/{username}")
public String updateUser(users user) {
     users existUser = repo.findById(user.getUsername()).get();
     existUser.setPassword(user.getPassword());
     repo.save(existUser);
     return "Updated!!";
}

// For user delete******************************************************
      @DeleteMapping("deleteUser/{username}")
    public String deleteUser(@PathVariable String username){
        repo.deleteById(username);
        return "user deleted "+username;
    }

}
