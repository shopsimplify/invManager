package com.shopesimple.invManager.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import com.shopesimple.invManager.Entity.users;
import com.shopesimple.invManager.Repos.crudDao;


@Service
public class crudService {
    @Autowired
    private crudDao repo;


// All users**************************************************************************
   public List<users> findAll()
   {
    return this.repo.findAll();
   }

//  Add user***************************************************
   public void addUser(users user)
    {
      repo.save(user);
    }

// find user*********************************************************************
  public Optional<users> findUser(String username)
  {
    return repo.findById(username);
  }


// Update user***************************************************************
    public  void userUpdate(users user,String username)
    {  
       user.setUsername(username);
       repo.save(user);                         
    }


//Delete user*************************************************************************************
public void deleteUser(String username) 
{
    repo.deleteById(username);
} 


}
