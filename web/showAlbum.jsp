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
    request.getSession().setAttribute("AID",aid);
    System.out.println("aid:"+aid);
%>
<div>当前用户：<%=user.getUserId()%> </div>
${path}
<div>
    <div>
        <form action="njnu15/servlet/UpLoadPic" enctype="multipart/form-data" id="loginform" name="loginform" method="post">
            选择图片：<input type="file" name="filename"/>
            <input id="subid" name="subid" type="submit" value="提交">
        </form>
    </div>
    <div id="back">
        <input type="button" value="返回" onclick="window.location.href='albumManagement.jsp'"/>
    </div>
</div>

<%

    List<Photo> list= DAO.findAllPhoto(aid);
    for(Photo photo:list){
        String pname = photo.getPhotoName();
        System.out.println(pname);
%>
<div class="photo">
    <img src="/image/<%=pname%>" width="200" height="200" alt="照片"/></br>
    <table>
        <tr><td>照片名称:</td><td><%=photo.getPhotoName() %></td></tr>
        <tr><td>上传时间:</td><td><%=photo.getUploadTime() %></td></tr>
        <tr>
            <td><a href="showPhoto.jsp?pid=<%=photo.getPhotoId() %>&pname=<%=photo.getPhotoName()%>&isMaster=true">查看</a></td>
            <%--<td><a href="comments.jsp?pid=<%=photo.getPhotoId() %>">评论</a></td>--%>
            <td><a href="njnu15/servlet/DelPhoto?PID=<%=photo.getPhotoId()%>" >删除</a></td>
        </tr>
    </table>
</div>
<% } %>
</body>
</html>
