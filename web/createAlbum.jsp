<%@ page import="njnu15.tool.AlbumCategory" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: CBL
  Date: 2019/1/5
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>创建相册</title>
</head>
<body>
    <div style="text-align:center">创建相册</div>
    <form action="/njnu15/servlet/createAlbum" method="post">
        <table border="0" cellspacing="1" cellpadding ="0"  align="center" style="border-collapse:separate; border-spacing:10px 10px;">
            <tr>
                <td colspan="2" align="center">相册名：</td>
                <td><input type="text" name="albumname"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">相册类别：</td>
                <td><select name="category">
                <%
                    List<String> list = AlbumCategory.getAlbumCategory();
                    for(String s:list){
                %>
                    <option value="<%=s%>"><%=s%></option>
                <%  } %>
                </select></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="reset" value="重置"/>
                    <input type="submit" value="提交"/>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
