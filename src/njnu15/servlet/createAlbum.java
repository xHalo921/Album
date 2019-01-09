package njnu15.servlet;
import java.text.SimpleDateFormat;
import java.util.Date;

import njnu15.bean.User;
import njnu15.tool.JDBCHelper;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "createAlbum")
public class createAlbum extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String select=request.getParameter("category");
        System.out.println(select);
        String aname = request.getParameter("albumname");
        User user=(User)request.getSession().getAttribute("user");
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(d);
        try {
            Connection conn= JDBCHelper.getConn();
            String sql="insert Into album(AlbumName,UserId,categoryName,CreateTime) Values('"+aname+"','"+user.getUserId()+"','"+select+"','"+date+"')";
            Statement stmt=conn.createStatement();
            stmt.executeUpdate(sql);
            request.getRequestDispatcher("/albumManagement.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
