package com.baidu.service;

import com.baidu.bean.User;

import javax.jms.Session;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

@WebServlet(name = "ExitServlet",value = "/exit")
public class ExitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        ServletContext sc = request.getServletContext();
        String username =  request.getParameter("uname");
        System.out.println(username);
        HashMap<String, User> map = (HashMap<String, User>) sc.getAttribute("people");
        User u = null;
        HttpSession ss=  request.getSession();
        ss.removeAttribute("username");
        ss.invalidate();
       for(String temp : map.keySet()){
            User u1 = map.get(temp);
            if(u1.getUname().equals(username)){
            u = u1;
            }
       }
        Collection<User> collect = map.values();
        if (collect.contains(u) == true) {
            collect.remove(u);
        }
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        ServletContext sc = request.getServletContext();
        String username =  request.getParameter("uname");
        System.out.println(username);
        HashMap<String, User> map = (HashMap<String, User>) sc.getAttribute("people");
        User u = null;
//        HttpSession ss=  request.getSession();
//        ss.removeAttribute("username");
//        ss.invalidate();
        for(String temp : map.keySet()){
            User u1 = map.get(temp);
            if(u1.getUname().equals(username)){
                System.out.println(u1);
                u = u1;
            }
        }
        Collection<User> collect = map.values();
        if (collect.contains(u) == true) {
            collect.remove(u);
        }
        response.sendRedirect(request.getContextPath() + "/test.jsp");
    }
}
