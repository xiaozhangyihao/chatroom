
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.*"%>
<%@ page import="com.baidu.bean.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<%
    HttpSession hs = request.getSession();
    User user = (User) hs.getAttribute("username");
    HashMap<String,User> map= (HashMap<String, User>) application.getAttribute("people");
    List<User> list = new ArrayList<>();
    for(String temp : map.keySet()){
        User u1 = map.get(temp);
        String uname = u1.getUname() ;
        out.print("<a>"+uname+"</a>");
        if(user.getType().equals("admin")&&u1.getType().equals("common")){
            out.print("<a href=exit?uname="+uname+">踢下线</a>");
        }
        out.print("<br />");
    }

%>
<%--for(String  temp : map.keySet()){--%>
<%--out.print(map.get(temp).getUname());--%>
<%--String tempName = map.get(temp).getUname();--%>
<%--if(user.getType().equals("admin")&&!temp.equals("admin")){--%>
<%--out.print("<a href=exit?uname="+tempName+">踢下线</a>");--%>
<%--}--%>
<%--out.print("<br />");--%>
<%--}--%>