<%@ page import="njnu15.bean.Album" %>
<%@ page import="java.util.*" %>
<%@ page import="njnu15.bean.User" %>
<%@ page import="njnu15.tool.DAO" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%--
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
    <base href="<%=basePath%>">
    <style type="text/css">
        .albums{
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
    <div>当前用户：<%=user.getUserId()%> </div>
    <table border="0" cellspacing="10" cellpadding ="10"  align="center" style="border-collapse:separate; border-spacing:10px 10px;">
        <tr>
            <td><a href="createAlbum.jsp">创建相册</a></td>
            <td><a href="login.jsp">退出登录</a></td>
        </tr>
    </table>
    <%
        List<Album> list=DAO.findAllAlbum(user);
        for(Album album:list){
            String pname = DAO.findFirstPhoto(album.getAlbumId());
    %>
        <div class="albums">
            <img src="/image/<%=pname%>" width="200" height="200" alt="照片"/></br>
            <table>
            <tr><td>相册名：<a href="showAlbum.jsp?albumId=<%=album.getAlbumId()%>"><%=album.getAlbumName() %></a></td></tr></br>
            <tr><td>类别：<%=album.getCategory() %></td></tr></br>
            <tr><td>创建时间：<%=album.getCreateTime() %></td></tr></br>
            <tr><td><a href="changeAlbum.jsp">修改</a></td><td><a href="">删除</a>></td></tr></br>
            </table>
        </div>
    <%  } %>
</body>
</html>
