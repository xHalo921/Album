<%@ page import="njnu15.bean.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="njnu15.tool.DAO" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%><%--
  Created by IntelliJ IDEA.
  User: xHole
  Date: 2019/1/7
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>好友列表</title>
    <base href="<%=basePath%>">
</head>
<body>
<%
    User user=(User)request.getSession().getAttribute("user");
    System.out.print("visit:"+user.getUserId());
    String visitId=user.getUserId();
    List<String> list=new ArrayList<>();
    list= DAO.findAllFriends(visitId);
    for (String friendId:list) {
%>
<td><a href="visitFriend.jsp?friendId=<%=friendId%>"><%=friendId%></a></td>
<%}%>
</body>
</html>
