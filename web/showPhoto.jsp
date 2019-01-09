
<%@ page import="njnu15.bean.Photo" %>
<%@ page import="java.util.List" %>
<%@ page import="njnu15.tool.DAO" %>
<%@ page import="njnu15.bean.Comment" %>
<%@ page import="njnu15.bean.User" %><%--
<%@ page import="njnu15.bean.User" %>
  Created by IntelliJ IDEA.
  User: CBL
  Date: 2019/1/6
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        #back{
            position:absolute;
            left:400px;
            top:8px;
        }
    </style>
</head>
<body>

<%
    User user=(User)request.getSession().getAttribute("user");
%>
<div >当前用户：<%=user.getUserId()%> </div></br>

    <div>
        <%
            int pid=Integer.parseInt(request.getParameter("pid"));
            int albumID=DAO.findAlbum(pid);
            boolean isMaster=Boolean.parseBoolean(request.getParameter("isMaster"));
            System.out.println("ismaster"+isMaster);
            String url=null;
            if(isMaster)
                url="/showAlbum.jsp?albumId="+albumID;
            else url="/visitAlbum.jsp?albumId="+albumID;
            System.out.println(pid);
            String pname=request.getParameter("pname");
        %>
        <img src="/image/<%=pname%>" width="300" height="300" alt="照片"/>

    </div>
    <div id="back">
        <input type="button" value="返回" onclick="window.location.href='<%=url%>'"/>
    </div>
    评论:<br/>
    <%
        List<Comment> list= DAO.findAllComment(pid);
        for(Comment comment:list) {
            String str = comment.getComments();
    %>

    <ul>
        <li>
            <%=comment.getUser()%>:<%=str%>
        </li>
    </ul>
    <%}%>
    <%
        request.getSession().setAttribute("PID",pid);
        request.getSession().setAttribute("Pname",pname);
    %>

    <form action="njnu15/servlet/AddComment?isMaster=<%=isMaster%>" method="post">
        发表评论：<br/>

        <textarea cols="60" rows="5" name="comments" ></textarea>

        <input type="submit" value="提交" name="comments"/>
    </form>

</body>
</html>
