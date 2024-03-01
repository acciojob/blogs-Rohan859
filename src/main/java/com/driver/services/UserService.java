package com.driver.services;

import com.driver.models.User;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository3;

    public User createUser(String username, String password){
        User obj= new User(username,password);
        userRepository3.save(obj);
        return obj;


    }

    public void deleteUser(int userId){

        userRepository3.deleteById(userId);



    }

    public User updateUser(Integer id, String password){
        User obj=userRepository3.findById(id).orElse(null);
        if(obj==null)
            return null;
        obj.setPassword(password);
        userRepository3.save(obj);
        return obj;


    }

//    public void createUser(String username,String password)
//    {
//        User user=new User(username,password);
//        userRepository.save(user);
//    }
//
//    public void updateUser(Integer id, String password)
//    {
//        User user=userRepository.findById(id).get();
//        if(user==null)
//        {
//            return;
//        }
//        user.setPassword(password);
//
//        userRepository.save(user);
//    }
//
//    public void deleteUser(int userId)
//    {
//        userRepository.deleteById(userId);
//    }
}