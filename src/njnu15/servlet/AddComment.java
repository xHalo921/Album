package njnu15.servlet;

import njnu15.bean.Comment;
import njnu15.bean.User;
import njnu15.tool.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddComment")
public class AddComment extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("AddCom");

        Comment comment=new Comment();
        //comment.setCommentId();
        User user=(User)request.getSession().getAttribute("user");
        int pid= (int) request.getSession().getAttribute("PID");
        comment.setPhotoId(pid);
        String str=new String(request.getParameter("comments").getBytes("iso-8859-1"),"UTF-8");
        comment.setComments(str);
        comment.setUser(user.getUserId());
        DAO.addComment(comment);
        System.out.println("pid:"+pid);
        System.out.println("Com:"+str);

        boolean isMaster=Boolean.parseBoolean(request.getParameter("isMaster"));
        String pname= String.valueOf(request.getSession().getAttribute("Pname"));
        System.out.println("isMaster:"+isMaster);
        response.sendRedirect("/showPhoto.jsp?pid="+pid+"&pname="+pname+"&isMaster="+isMaster);
        //response.sendRedirect("/showPhoto.jsp?pid="+pid+"&pname="+pname);
    }
}
