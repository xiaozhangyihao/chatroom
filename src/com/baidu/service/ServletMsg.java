package com.baidu.service;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ServletMsg",value = "/msg")
public class ServletMsg extends HttpServlet {
    List<String> list = new ArrayList<String>();
    List<String> list2 = new ArrayList<String>();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=utf-8");
//            response.setCharacterEncoding("");
            String msg = request.getParameter("msg");
            if(msg.length()==0){
                response.getWriter().println("<script language='javascript'>alert('消息不能为空!');</script>");
                response.sendRedirect(request.getContextPath() + "/test.jsp");
                return;
            }
            String username = request.getParameter("username");
            String date = new Date().toLocaleString();
            String valueMsg = username+""+msg+"&nbsp&nbsp&nbsp" +date;//消息拼接
            ServletContext sc = getServletContext();
            list.add(valueMsg);
            list2.add(valueMsg);//这个集合存放历史消息
            sc.setAttribute("msg",list);
             sc.setAttribute("his",list2);
            request.getRequestDispatcher("test.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
