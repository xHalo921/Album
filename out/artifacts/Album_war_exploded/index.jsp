<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>登录界面</title>
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

<form action="njnu15/servlet/examine" method="post">
  <table border="0" cellspacing="1" cellpadding ="0"  align="center" style="border-collapse:separate; border-spacing:10px 10px;">
    <tr>
      <td colspan="2" align="center">用户登录</td></tr>
    </tr>
    <tr>
      <td>用户名：</td><td><input type="text" name="username"></td>
      <td><span id="checkUsername" style="color:red"></span></td>
    </tr>
    <tr>
      <td>密&nbsp;&nbsp;&nbsp;&nbsp;码：</td><td><input type="password" name="password"></td>
      <td><span id="checkPassword" style="color:red"></span></td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="reset" value="重置"/>
        <input type="submit" value="登录"/>
        <input type="button" value="注 册" onclick="window.open('register.jsp')">
      </td>
    </tr>
  </table>
</form>
</body>
</html>
