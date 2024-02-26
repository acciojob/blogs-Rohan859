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

    public void deleteUser(int userId){

         final String JDBC_URL = "jdbc:mysql://localhost:3306/blogs?createTableIfNotExists=true";
         final String USERNAME = "root";
        final String PASSWORD = "Kan@2911";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "DELETE FROM your_user_table WHERE user_id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, userId);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("User with ID " + userId + " deleted successfully.");
                } else {
                    System.out.println("User with ID " + userId + " not found.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }
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
