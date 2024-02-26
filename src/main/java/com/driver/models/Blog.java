package com.driver.models;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Blog
{
    @Id
    private Integer userId;
    private String title;
    private String content;

    public Blog() {
    }

    public Blog(Integer userId, String title, String content) {
        this.userId = userId;
        this.title = title;
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}