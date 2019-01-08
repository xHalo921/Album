package njnu15.servlet;

import njnu15.bean.User;
import njnu15.tool.AlbumCategory;
import njnu15.tool.DAO;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class addFriend extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String friendId=request.getParameter("friendId");
        User user=(User)request.getSession().getAttribute("user");
        int state = DAO.addFriend(friendId,user.getUserId());
        String s;
        switch (state){
            case -1:
                s="该用户不存在";
                break;
            case 0:
                s="你们已经是好友啦";
                break;
            default:
                s="添加成功";
        }
        request.getRequestDispatcher("/myFriends.jsp?result="+s).forward(request,response);
    }
}
