package njnu15.servlet;

import njnu15.bean.User;
import njnu15.tool.DAO;
import njnu15.tool.JDBCHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {

    //public final String success = "/registerSuccess.jsp";
    //public final String failure = "/registerFailure.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        User user=new User();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        user.setUserId(username);
        user.setPassword(password);
        user.setGender(gender);
        request.setAttribute("username", username);
        try {
            Connection conn= JDBCHelper.getConn();
            PreparedStatement pStmt = conn.prepareStatement("select * from user where User = '" + username + "'");
            ResultSet rs = pStmt.executeQuery();
            if(rs.next()){
                response.sendRedirect("/register.jsp?message=register_error");
            }else{
                DAO.addUser(user);
                request.getSession().setAttribute("user",user);
                request.getRequestDispatcher("/albumManagement.jsp").forward(request, response);

            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
