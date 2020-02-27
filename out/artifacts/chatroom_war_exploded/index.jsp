<%--
  Created by IntelliJ IDEA.
  User: YYY
  Date: 2019/12/17
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <style type="text/css">
          body{
              text-align:center;
          }
          #div1{
              background: url(imgs/bg.jpg) darkturquoise;
              width: 600px;
              height: 300px;
              margin:0 auto;

          }
          #inp1 {
              width: 200px;
              height: 30px;
          }
          #inp2{
              width: 200px;
              height: 30px;
              margin-top: 10px;
          }
          #in3{
             /*width: ; */
          }
      </style>
    <title>chatroom</title>
  </head>
  <body>
  <div id="div1">
      <h1><font size="7" color="cadetblue">聊天室登录</font></h1>
      <%
         String err =(String) request.getAttribute("err");
         if(err==null){
             err = "";
         }
         out.println("<font color='red'>"+err+"</font>");
      %>
      <form action="${pageContext.request.contextPath }/user" method="post">
          <input type="hidden" name="method" value="login">
          <font size="3">账号:</font><input id="inp1" type="text" name = "username" /><br />
          <font size="3">密码:</font><input id="inp2" type="password" name = "password" /><br />
          <input id="in3" type="submit" value="登录" />
      </form>
  </div>
  </body>
</html>
<script>

</script>
