package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;


@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;

    public void createAndReturnBlog(Integer userId , String title,String content)
    {
        Blog blog=new Blog(title,content);

        User user=userRepository1.findById(userId).get();

        blog.setUser(user);

        blog.setPubDate(new Date());

        List<Blog>blogs=user.getBlogList();
        blogs.add(blog);

//        blogRepository1.save(blog);
        userRepository1.save(user);

    }


    public void deleteBlog(int blogId)
    {
        blogRepository1.deleteById(blogId);
    }

}
