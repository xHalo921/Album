package njnu15.servlet;

import njnu15.bean.Album;
import njnu15.tool.AlbumCategory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class addCategory extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String s=request.getParameter("newCategory");
        System.out.println(s);
        AlbumCategory.addCategory(s);
        request.getRequestDispatcher("/categoryManagement.jsp").forward(request,response);
    }
}
