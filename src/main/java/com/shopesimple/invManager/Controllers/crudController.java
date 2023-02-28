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
import com.shopesimple.invManager.Service.crudService;


@RestController
public class crudController {
    crudService crudservice;
    
    // For fetch all users****************************************************
        @GetMapping("/allUsers")
        public List<users> userList(){
            return crudservice.findAll();
        }
    
    // For add user**************************************************
    @PostMapping("/addUser")
    public String addUser(@RequestBody users user){
        crudservice.addUser(user);    
        return "user added!!";
    }


// For user find*******************************************************
     @GetMapping("/userFind/{username}")
    public Optional<users> userFind(@PathVariable String username){
       return crudservice.findUser(username);
    }
//For update users *********************************************pending
// @PutMapping("/updateUser/{username}")
// public String updateUser(@RequestBody users user, @PathVariable("username") String username) {
//          crudService.userUpdate(user, username);
//      return "Updated!!";
     
// }

// For user delete******************************************************
      @DeleteMapping("deleteUser/{username}")
       public String deleteUser(@PathVariable String username){
         crudservice.deleteUser(username);
        return "user deleted "+username;
    }

}
