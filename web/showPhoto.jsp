<%@ page import="njnu15.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: CBL
  Date: 2019/1/6
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">

    </style>
</head>
<body>
    <%
        User user=(User)request.getSession().getAttribute("user");
    %>
    <div style="text-align:center">当前用户：<%=user.getUserId()%> </div>
    <div>
        <%
            String pid=request.getParameter("pid");
            System.out.println(pid);
            String pname=request.getParameter("pname");
        %>
        <img src="/image/<%=pname%>" width="300" height="300" alt="照片"/>

    </div>
</body>
</html>
