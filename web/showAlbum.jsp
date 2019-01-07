<%@ page import="njnu15.bean.*" %>
<%@ page import="java.util.List" %>
<%@ page import="njnu15.tool.DAO" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%><%--
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
    <base href="<%=basePath%>">
    <style type="text/css">
        .photo{
            float:left;
            margin:20px;
        }
    </style>
</head>
<body>
    <%
        User user=(User)request.getSession().getAttribute("user");
        int aid=Integer.parseInt(request.getParameter("albumId"));
        request.getSession().setAttribute("AID",aid);
        System.out.println("aid:"+aid);
    %>
    <div>当前用户：<%=user.getUserId()%> </div>
    ${path}
    <form action="njnu15/servlet/UpLoadPic" enctype="multipart/form-data" id="loginform" name="loginform" method="post">
        选择图片：<input type="file" name="filename"/>
        <input id="subid" name="subid" type="submit" value="提交">
    </form>
    <%

        List<Photo> list= DAO.findAllPhoto(aid);
        for(Photo photo:list){
            String pname = photo.getPhotoName();
            System.out.println(pname);
    %>
    <div class="photo">
        <tr><td><img src="/image/<%=pname%>" width="100" height="100" alt="照片"/></td></tr></br>
        <tr><a>照片名称:</a><td><%=photo.getPhotoName() %></td></tr></br>
        <tr><a>照片上传时间:</a><td><%=photo.getUploadTime() %></td></tr></br>
        <tr>
            <td><a href="showPhoto.jsp?pid=<%=photo.getPhotoId() %>">查看</a></td>
            <%--<td><a href="comments.jsp?pid=<%=photo.getPhotoId() %>">评论</a></td>--%>
            <td><a href="deletePhoto.jsp?pid=<%=photo.getPhotoId() %>">删除</a></td>
        </tr></br>
    </div>
    <% } %>
</body>
</html>
