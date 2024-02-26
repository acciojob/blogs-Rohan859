package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hibernate.jpa.AvailableSettings.*;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;

    public Blog createAndReturnBlog(Integer userId, String title, String content)
    {
        //create a blog at the current time
        Blog blog=new Blog(userId,title,content);
        blogRepository1.save(blog);
        return blog;
    }

    public void deleteBlog(int blogId)
    {
         final String JDBC_URL = "jdbc:mysql://localhost:3306/blogs?createTableIfNotExists=true";
         final String JDBC_USER = "root";
         final String JDBC_PASSWORD = "Kan@2911";
        //delete blog and corresponding images
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {

            // Delete blog and corresponding images
            String deleteBlogQuery = "DELETE FROM blogs WHERE blog_id = ?";
            String deleteImagesQuery = "DELETE FROM images WHERE blog_id = ?";

            try (PreparedStatement deleteBlogStatement = connection.prepareStatement(deleteBlogQuery);
                 PreparedStatement deleteImagesStatement = connection.prepareStatement(deleteImagesQuery)) {

                // Set parameters
                deleteBlogStatement.setInt(1, blogId);
                deleteImagesStatement.setInt(1, blogId);

                // Execute deletion queries
                int blogDeletionResult = deleteBlogStatement.executeUpdate();
                int imagesDeletionResult = deleteImagesStatement.executeUpdate();

                if (blogDeletionResult > 0) {
                    System.out.println("Blog with ID " + blogId + " deleted successfully");
                } else {
                    System.out.println("Blog with ID " + blogId + " not found");
                }

                System.out.println(imagesDeletionResult + " images deleted");

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
