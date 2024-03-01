package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;


    public void addImage(int blogId,String description,String dimensions)
    {
        Blog blog=blogRepository2.findById(blogId).orElseGet(null);

        if(blog==null)
        {
            return;
        }
        Image image=new Image(description,dimensions);

        image.setBlog(blog);

        blog.getImageList().add(image);

        imageRepository2.save(image);
        blogRepository2.save(blog);
    }

    public int countImagesInScreen( int id,  String screenDimensions)
    {
        Image image=imageRepository2.findById(id).orElse(null);

        if(image==null)
        {
            return 0;
        }

        String  arr[]=(image.getDimensions().split("X",2));


        String  arr2[]=(screenDimensions.split("X",2));

        int count=(int)(Math.floor((double)Integer.parseInt(arr2[0])/(double)Integer.parseInt(arr[0]))*Math.floor((double)Integer.parseInt(arr2[1])/(double)Integer.parseInt(arr[1])));

        return count;
    }

    public void deleteImage(int id)
    {
        imageRepository2.deleteById(id);
    }
}
