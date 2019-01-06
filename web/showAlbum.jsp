<%--
  Created by IntelliJ IDEA.
  User: CBL
  Date: 2019/1/6
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>相册内容</title>
</head>
<body>
    <div style="text-align:center">当前用户：<%=request.getSession().getAttribute("username")%> </div>
    <tr>
        <td><a href="uploadPhoto.jsp">上传照片</a></td>
    </tr>
    <%
        String aid=request.getParameter("albumId");
        List<Photo> list=DAO.findAllPhoto(aid);
        for(Photo photo:list){
    %>
    <div class="photo">
        <tr><td><img src="<%=path%>/file/<%=photo.getPhotoName() %>" width="100" height="100"/></td>
        <tr><a>照片名称:</a><td><%=photo.getPhotoName() %></td></tr>
        <tr><a>照片所属相册名称:</a><td><%=photo.getAlbumName() %></td></tr>
        <tr><td><a href="deletePhoto.jsp?pid=<%=photo.getPhotoId() %>">删除照片:</a></td></tr>
    </div>
    <%} %>
</body>
</html>