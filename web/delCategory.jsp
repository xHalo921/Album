<%@ page import="njnu15.tool.AlbumCategory" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%><%--
  Created by IntelliJ IDEA.
  User: xHole
  Date: 2019/1/7
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除相册类别</title>
    <base href="<%=basePath%>">
</head>
<body>
<%
    int CategoryId=Integer.parseInt(request.getParameter("CategoryId"));
    AlbumCategory.delCategory(CategoryId);
%>
<br>删除成功</br>
<td><a href="categoryManagement.jsp">点击返回</a></td>
</body>
</html>
