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
  User: xHole
  Date: 2019/1/5
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>好友相册</title>
    <base href="<%=basePath%>">
    <style type="text/css">
        .albums{
            float:left;
            margin:20px;
        }
    </style>
</head>
<body>
<div style="text-align:center">好友相册</div>
<%
    User user=(User)request.getSession().getAttribute("user");
    String friendId=request.getParameter("friendId");
    User mater=new User();
    mater.setUserId(friendId);
%>
<div>当前用户：<%=user.getUserId()%> </div>
<%
    List<Album> list=DAO.findAllAlbum(mater);
    for(Album album:list){
        String pname = DAO.findFirstPhoto(album.getAlbumId());
%>
<div class="albums">
    <img src="/image/<%=pname%>" width="200" height="200" alt="照片"/></br>
    <table>
        <tr><td>相册名：<a href="visitAlbum.jsp?albumId=<%=album.getAlbumId()%>"><%=album.getAlbumName() %></a></td></tr></br>
        <tr><td>类别：<%=album.getCategory() %></td></tr></br>
        <tr><td>创建时间：<%=album.getCreateTime() %></td></tr></br>
    </table>
</div>
<%  } %>
<td><a href="myFriends.jsp?result">返回好友列表</a></td>
</body>
</html>
