<%@ page import="njnu15.bean.*" %>
<%@ page import="java.util.List" %>
<%@ page import="njnu15.tool.DAO" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%><%--
  Created by IntelliJ IDEA.
  User: xHole
  Date: 2019/1/6
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>相册内容</title>
    <base href="<%=basePath%>">
    <style type="text/css">
        .photo{
            float:left;
            margin:20px;
        }
        #back{
            position:absolute;
            left:500px;
            top:28px;
        }
    </style>
</head>
<body>
<%
    User user=(User)request.getSession().getAttribute("user");
    int aid=Integer.parseInt(request.getParameter("albumId"));
%>
<div>当前用户：<%=user.getUserId()%> </div>
${path}
<%
    List<Photo> list= DAO.findAllPhoto(aid);
    for(Photo photo:list){
        String pname = photo.getPhotoName();
        System.out.println(pname);
%>
<div class="photo">
    <img src="/image/<%=pname%>" width="200" height="200" alt="照片"/></br>
    <table>
        <tr><a>照片名称:</a><td><%=photo.getPhotoName() %></td></tr>
        <tr><a>照片上传时间:</a><td><%=photo.getUploadTime() %></td></tr>
        <tr>
            <td><a href="showPhoto.jsp?pid=<%=photo.getPhotoId() %>&pname=<%=photo.getPhotoName()%>">查看</a></td>
        </tr>
    </table>
</div>
<% } %>
</body>
</html>
