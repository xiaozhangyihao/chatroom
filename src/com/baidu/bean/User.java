package com.baidu.bean;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.util.Map;

public class User{
    private int id;
    private String uname;
    private  String upwd;
    private String type;

    public User() {
    }

    public User(int id, String uname, String upwd, String type) {
        this.id = id;
        this.uname = uname;
        this.upwd = upwd;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

}
