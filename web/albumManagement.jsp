<%@ page import="njnu15.bean.Album" %>
<%@ page import="java.util.List" %>
<%@ page import="njnu15.bean.User" %>
<%@ page import="njnu15.tool.DAO" %><%--
  Created by IntelliJ IDEA.
  User: CBL
  Date: 2019/1/5
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>相册管理</title>
    <style type="text/css">
        .album{
            float:left;
            margin:20px;
        }
    </style>
</head>
<body>
    <div style="text-align:center">用户相册管理</div>
    <%
        User user=(User)request.getSession().getAttribute("user");

    %>
    <div style="text-align:center">当前用户：<%=user.getUserId()%> </div>
    <table border="0" cellspacing="10" cellpadding ="10"  align="center" style="border-collapse:separate; border-spacing:10px 10px;">
        <tr>
            <td><a href="createAlbum.jsp">创建相册</a></td>
            <td><a href="login.jsp">退出登录</a></td>
        </tr>
    </table>
    <%
        List<Album> list=DAO.findAllAlbum(user);
        for(Album album:list){
    %>
        <div class="album">
            <!--<a href="album.jsp"><img src="<!=path%>/<!=album.getAlbumName() %>" width="100" height="100"/></a>-->
            <tr><td>相册名：<%=album.getAlbumName() %></td></tr>
            <tr><td>类别：<%=album.getCategory() %></td></tr>
            <tr><td>创建时间：<%=album.getCreateTime() %></td></tr>
            <tr><td><a href="changeAlbum.jsp">修改</a>></td><td><a href="">删除</a>></td></tr>
        </div>
    <%  } %>
</body>
</html>
