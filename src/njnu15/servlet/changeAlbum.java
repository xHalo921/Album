package njnu15.servlet;

import njnu15.bean.Album;
import njnu15.tool.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "changeAlbum")
public class changeAlbum extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int alid = (Integer)request.getSession().getAttribute("alid");
        String alname = request.getParameter("albumname");
        String cate = request.getParameter("category");
        DAO.changeAlbum(alid,alname,cate);
        response.sendRedirect("/albumManagement.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
