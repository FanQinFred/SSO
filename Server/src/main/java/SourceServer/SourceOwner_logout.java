package SourceServer;

import dao.UserDao;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @className: SourceOwner_logout
 * @packageName: SourceServer
 * @description: 用于APP的登出操作
 **/
@WebServlet(name = "SourceOwner_logout")
public class SourceOwner_logout extends HttpServlet {
    /**
     @description:处理doPost请求
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        try {
            User user = UserDao.get(username);
            user.setTk(null);
            //登出是删除存在数据库的APP的Token
            UserDao.update(user,username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("doPost");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
