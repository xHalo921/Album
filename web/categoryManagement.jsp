<%@ page import="java.util.List" %>
<%@ page import="njnu15.tool.AlbumCategory" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%--
  Created by IntelliJ IDEA.
  User: CBL
  Date: 2019/1/5
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>相册类别管理</title>
    <base href="<%=basePath%>">
</head>
<body>
<p>当前类别：</p>
<%
    List<String> list= AlbumCategory.getAlbumCategory();
    for(int i=0;i<list.size();i++){
        String categoryName=list.get(i);
%>
<div>
    <td><%=categoryName%>  <a href="delCategory.jsp?categoryName=<%=categoryName%>">删除类别</a></td>
</div>
<%}%>
<form action="njnu15/servlet/addCategory" method="post">
    <td><input type="text" name="newCategory"><input type="submit" value="新增"/></td>
</form>
<td><a href="login.jsp">退出登录</a></td>
</body>
</html>
