<%@ page import="javafx.application.Application" %>
<%@ page import="com.baidu.bean.User" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: YYY
  Date: 2019/12/18
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <style type="text/css">
        body{
            text-align:center;
        }
        #div1{
            background: url(imgs/aa.jpg) darkturquoise;
            width: 800px;
            height: 100px;
            margin:0 auto;
        }
        #div2{
            width: 800px;
            height: 300px;
            margin:0 auto;
        }
        #div3{
            background: #00CED1;
            width: 200px;
            height: 300px;

            float: left;
        }
        #div4{
            background: cyan;
            width: 600px;
            height: 300px;
            float: right;
        }
    </style>
</head>
<body>
<div id="div0">
</div>
<div id="div1">
    <h1>欢迎来到聊天室</h1>
</div>
<div id="div2">
    <div id="div3">
        在线人员列表 <br/>
        <div id="online">
</div>
</div>
<div id="div4">
请遵守聊天规则,不要使用不文明用语
<div id="divmsg">

</div>
</div>
</div>
<div id="div5">
<form method="post" action="${pageContext.request.contextPath }/msg" >
<%
User user2 = (User) session.getAttribute("username");
String myname = user2.getUname();
out.print(user2.getUname()+"说:");
String username = user2.getUname()+"说:";
%>
<%--    获取消息并且发送--%>
    <input type="hidden" name="username" value="<%= username %>" >
<input id="txt" name="msg" type="text" width="100px" />
    <input type="submit" value="发送"  id="send"  /><br />
</form>
    <form method="post" action="${pageContext.request.contextPath }/exit">
        <input type="hidden"  name="uname" value="<%= myname %>" />
    <input type="submit" value="退出" id="tuichu" />
    </form>
    <form method="post" action="${pageContext.request.contextPath }/his">
        <input type="submit" value="查看历史消息" id="his" />
    </form>
</div>
</body>
</html>
<script type="text/javascript" src="${ pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
window.setInterval("showOnLine();",2000);
window.setInterval("showMsg();",1000)
window.setInterval("check();",2500);
$(function(){
showOnLine();
showMsg();
check();
});
function showOnLine(){
$.post("${pageContext.request.contextPath}/online.jsp?"+new Date().getTime(),function(data){
$("#online").html(data);
});
}
function showMsg(){
    $.post("${pageContext.request.contextPath}/massage.jsp?"+new Date().getTime(),function(data){
        $("#divmsg").html(data);
    });
}
function check(){
    $.post("${pageContext.request.contextPath}/check.jsp?"+new Date().getTime(),function(data){
        $("#div0").html(data);
    });
}
</script>
