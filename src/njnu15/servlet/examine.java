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
            String sql = "SELECT * FROM userkey WHERE user='"+ user.getUserId() +"' and password='"+ user.getPsaaword() +"'";
            Statement stmt=conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next())   return true;
            else            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws javax.servlet.ServletException, IOException {
        User user=new User();
        user.setUserId(request.getParameter("username"));
        user.setPsaaword(request.getParameter("password"));

        if (find(user)){
            request.setAttribute("user",user);
            request.getRequestDispatcher("albumManagement.jsp").forward(request,response);
        }
        else response.sendRedirect("/index.jsp?message=login_error");
    }
}
