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
    <%
        String result=request.getParameter("result");
        if (!result.equals("")){
            System.out.println("result"+result);
    %>
    <script type="text/javascript">
        alert("<%=result%>");
    </script>
    <%}%>
    <base href="<%=basePath%>">
</head>
<body>
点击好友名进入好友相簿</br>
<%
    User user=(User)request.getSession().getAttribute("user");
    System.out.println("visit:"+user.getUserId());
    String visitId=user.getUserId();
    List<String> list=new ArrayList<>();
    list= DAO.findAllFriends(visitId);
    for (String friendId:list) {
%>
<td><a href="visitFriend.jsp?friendId=<%=friendId%>"><%=friendId%></a></td>
<td><a href="njnu15/servlet/delFriend?friendId=<%=friendId%>">删除好友</a></td>
<%}%>
<form action="njnu15/servlet/addFriend" method="post">
    <td>要添加好友名：</td><td><input type="text" name="friendId"></td>
    <input type="submit" value="添加"/>
</form>
<td><a href="albumManagement.jsp">返回相簿</a></td>
</body>
</html>
