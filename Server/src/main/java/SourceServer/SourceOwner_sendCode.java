package SourceServer;

import Utils.XorEncryption;
import dao.UserDao;
import domain.User;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class SourceOwner_sendCode extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收账号密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String LOCAL_SERVICE=request.getParameter("LOCAL_SERVICE");
        //验证账号密码

        try {
            User user = UserDao.get(username);
            if(user!=null&&user.pwd.equals(password)){
                int key=0x10;
                // code加密
                String code= XorEncryption.stringEncryption(username,key);
                response.sendRedirect(LOCAL_SERVICE+"_dealWithCode?code="+code+"&username="+username+"&LOCAL_SERVICE="+LOCAL_SERVICE);
            }
            else{
                response.sendRedirect(LOCAL_SERVICE+"?info=YourUsernameOrPasswordIsWrong.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }
}
