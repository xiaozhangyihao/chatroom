<%@ page import="com.baidu.bean.User" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: YYY
  Date: 2019/12/25
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%          //进入时判断是否是直接进入的
    User user = (User) session.getAttribute("username");
    Map<String,User> map = (Map<String, User>) application.getAttribute("people");
    if(user==null){
        out.println("<script language='javascript'>alert('您的账户已经过期，请重新登录!');window.location='index.jsp';</script>");
        return;
    }
    if(!map.values().contains(user)){
        out.println("<script language='javascript'>alert('您的账户已经过期，请重新登录!');window.location='index.jsp';</script>");
        return;
    }
%>
