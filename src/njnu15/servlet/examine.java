package njnu15.servlet;
import njnu15.bean.User;
import njnu15.tool.JDBCHelper;

import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class examine extends HttpServlet {
    private static boolean find(User user){
        try {
            Connection conn= JDBCHelper.getConn();
            String sql = "SELECT * FROM user WHERE User='"+ user.getUserId() +"' and Password='"+ user.getPassword() +"'";
            Statement stmt=conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws javax.servlet.ServletException, IOException {
        User user=new User();
        user.setUserId(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));

        if (find(user)){
            request.getSession().setAttribute("user",user);
            request.getRequestDispatcher("/albumManagement.jsp").forward(request,response);
        }
        else response.sendRedirect("/login.jsp?message=login_error");
    }
}
