package com.driver.services;

import com.driver.models.Blog;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
         Blog blog=blogRepository1.findById(blogId).orElse(null);
         if(blog==null)
         {
             return;
         }

        blogRepository1.deleteById(blogId);
    }
}
