package njnu15.servlet;

import njnu15.bean.User;
import njnu15.tool.DAO;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class delFriend extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws javax.servlet.ServletException, IOException {
        String friendId=request.getParameter("friendId");
        User user=(User)request.getSession().getAttribute("user");
        DAO.delFriend(friendId,user.getUserId());
        request.getRequestDispatcher("/myFriends.jsp?result").forward(request,response);
    }
}
