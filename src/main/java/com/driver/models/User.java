package com.driver.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String ussername;
    String password;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Blog> arr;
    public User(){
        arr=new ArrayList<>();
    }
    public User(String x, String y){
        ussername=x;
        password=y;
        arr=new ArrayList<>();
    }

    public User(Integer userId) {
        arr=new ArrayList<>();
        id=userId;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return ussername;
    }

    public void setUsername(String ussername) {
        this.ussername = ussername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Blog> getBlogList() {
        return arr;
    }

    public void setBlogList(List<Blog> x) {
        this.arr=x;
    }
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int id;
//
//    private String username;
//    private String password;
//
//    @OneToMany
//    List<Blog>blogList=new ArrayList<>();
//
//    public User() {
//
//    }
//
//    public User(int id) {
//        this.id = id;
//    }
//
//    public User(String userName, String password) {
//        this.username = userName;
//        this.password = password;
//    }
//
//    public List<Blog> getBlogList() {
//        return blogList;
//    }
//
//    public void setBlogList(List<Blog> blogList) {
//        this.blogList = blogList;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String userName) {
//        this.username = userName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", userName='" + username + '\'' +
//                ", password='" + password + '\'' +
//                ", blogList=" + blogList +
//                '}';
//    }
}