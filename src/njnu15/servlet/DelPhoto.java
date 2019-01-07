package njnu15.servlet;

import njnu15.tool.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DelPhoto")
public class DelPhoto extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int x= (int) request.getSession().getAttribute("AID");
        int pid= Integer.parseInt(request.getParameter("PID"));
        //System.out.println("Del:"+pid);
        DAO.delPhoto(pid);
        request.getRequestDispatcher("/showAlbum.jsp?albumId="+x).forward(request,response);
    }
}
