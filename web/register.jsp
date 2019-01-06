<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
    <%
        if("login_error".equals(request.getParameter("message"))){ %>
            <script type="text/javascript">
                alert("该用户名已存在！");
            </script>
    <% }%>
    <script type="text/javascript">
        function checkForm(form) {
            if(form.username.value == "") {
                alert("用户名不能为空!");
                form.username.focus();
                return false;
            }
            if(form.password.value == "") {
                alert("密码不能为空!");
                form.password.focus();
                return false;
            }
            if(form.sex.value == "") {
                alert("性别不能为空!");
                form.password.focus();
                return false;
            }
            return true;
        }
        window.onload = function () {
            var myform = document.forms[0];
            myform.onsubmit = function () {
                return checkForm(this);
            }
        }
    </script>
</head>
<body>
    <form action="" method="post">
        <table border="0" cellspacing="1" cellpadding ="0" align="center" style="border-collapse:separate; border-spacing:10px 10px;">
            <tr>
                <td colspan="2" align="center">用户注册</td>
            </tr>
            <tr>
                <td>用户名：</td><td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>电&nbsp;&nbsp;&nbsp;&nbsp;话：</td><td><input type="text" name="phonenumber"></td>
            </tr>
            <tr>
                <td>密&nbsp;&nbsp;&nbsp;&nbsp;码：</td><td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>性&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
                <td>男<input type="radio" name="sex" value="male">&nbsp;&nbsp;&nbsp;&nbsp;
                    女<input type="radio" name="sex" value="female"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="reset" value="重置">
                    <input type="submit" value="提交">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
