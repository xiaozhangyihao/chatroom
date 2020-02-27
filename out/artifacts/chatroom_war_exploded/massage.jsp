<%@ page import="javafx.application.Application" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.baidu.bean.User" %>
<%@ page import="com.baidu.dao.impl.UserDaoImpl" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: YYY
  Date: 2019/12/18
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
<%
        String msg = "";
        ArrayList<String> list1 = (ArrayList<String>) application.getAttribute("msg");
        if(list1!=null){
            for(String massage : list1 ){
                msg +=massage+"<br/>";
            }
            if(msg!=null){
                response.getWriter().println(msg);
                if(list1.size()>12){
                    list1.remove(0);
                }
            }
        }

%>
</div>
