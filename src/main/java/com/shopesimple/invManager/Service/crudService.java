package com.shopesimple.invManager.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.shopesimple.invManager.Models.users;
import com.shopesimple.invManager.Repos.crudDao;

public class crudService {
    @Autowired
    private crudDao repo;

    // All users
   public List<users> findAll()
   {
    return repo.findAll();
   }

// find user
  public Optional<users> findUser(String username)
  {
    return repo.findById(username);
  }

// Add user
    public void addUser(users user)
    {
        repo.save(user);
    }

// Update user
    public static void userUpdate(users user,String username)
    {
        

    }

//Delete user
public void deleteUser(String username) 
{
    repo.deleteById(username);
} 


}
