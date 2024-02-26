package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository3;

    public User createUser(String username, String password){

        User user=new User(username,password);
        userRepository3.save(user);
        return user;
    }

    public void deleteUser(int userId)
    {
        User user=userRepository3.findById(userId).orElse(null);
        if(user==null)
        {
            return;
        }
        userRepository3.deleteById(userId);
    }

    public User updateUser(Integer id, String password)
    {
        User existingUser=userRepository3.findById(id).orElse(null);

        if(existingUser!=null)
        {
            existingUser.setPassword(password);
            userRepository3.save(existingUser);
            return existingUser;
        }
        return null;
    }
}
