package njnu15.servlet;

import njnu15.tool.AlbumCategory;
import njnu15.tool.DAO;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class delAlbum extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws javax.servlet.ServletException, IOException {
        int albumId=Integer.parseInt(request.getParameter("albumId"));
        DAO.delAlbum(albumId);
        request.getRequestDispatcher("/albumManagement.jsp").forward(request,response);
    }
}
