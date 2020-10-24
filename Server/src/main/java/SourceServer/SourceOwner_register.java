package SourceServer;

import dao.UserDao;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SourceOwner_register")
public class SourceOwner_register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String conf_password = request.getParameter("conf_password");
        String phone_num = request.getParameter("phone_num");
        String LOCAL_SERVICE=request.getParameter("LOCAL_SERVICE");
        if(password.equals(conf_password)){
            try {
                User user = UserDao.get(username);
                if(user==null){
                    User new_user=new User();
                    new_user.setUsr_name(username);
                    new_user.setPwd(password);
                    new_user.setPhone_num(phone_num);
                    new_user.setTk(null);
                    UserDao.add(new_user);
                    response.sendRedirect(LOCAL_SERVICE+"?info=NowYouCanLogin.");
                }
                else{
                    response.sendRedirect(LOCAL_SERVICE+"_register?info=TheUsernameIsUsed.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            response.sendRedirect(LOCAL_SERVICE+"_register?info=TwoPasswordsIsNotTheSame.");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
