<%@ page import="njnu15.bean.Photo" %>
<%@ page import="njnu15.tool.DAO" %><%--
  Created by IntelliJ IDEA.
  User: CBL
  Date: 2019/1/6
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>评论</title>
    <style type="text/css">
        .comment{
            float:left;
            margin:20px;
        }
    </style>
</head>
<body>
    <div style="text-align:center">当前用户：<%=request.getSession().getAttribute("username")%> </div>
    <%
        String pid=request.getParameter("pid");
        Photo photo = DAO.findPhoto(pid);
    %>
    <div>
        <div class="comment">
            <img src="<%=path%>/file/<%=photo.getPhotoName() %>" width="300" height="300"/>
        </div>
        <div class="comment">
        </div>
    </div>
</body>
</html>
