<%@ page import="javafx.application.Application" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: YYY
  Date: 2019/12/19
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <font size="6" color="blue">历史消息</font>
    <div>
    <%
        List<String> list = (List<String>) application.getAttribute("his");
        String msg = "";
        if(list!=null){
             for(String massage : list ){
                  msg +=massage+"<br/>";
                }
        }
        if(msg!=null){
            response.getWriter().println(msg);
            if(list.size()>12){
                list.remove(0);
            }
        }
    %>
    </div>
</body>
</html>
