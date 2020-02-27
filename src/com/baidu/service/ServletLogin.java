package com.baidu.service;

import com.baidu.bean.User;
import com.baidu.dao.impl.UserDaoImpl;

import javax.jms.Session;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ServletLogin",value="/user")
public class ServletLogin extends HttpServlet {
    Map<String,User> map = new HashMap<>();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("username");
        String pwd = request.getParameter("password");
        User user = new User();
        user.setUpwd(pwd);
        user.setUname(name);
        UserDaoImpl udi = new UserDaoImpl();
        User user1 =  udi.Login(user);
        ServletContext sc =  request.getServletContext();
        sc.setAttribute("people",map);
        if (user1==null){
            request.setAttribute("err","’À∫≈ªÚ√‹¬Î¥ÌŒÛ");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else{
            HttpSession hs = request.getSession();
            hs.setAttribute("username",user1);
           map.put(user1.getUname(),user1);
            request.getRequestDispatcher("test.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                doPost(request,response);
    }
}
