package Controller;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;


/**
 * @className: app01_dealWithToken
 * @packageName: Controller
 * @description: 接收服务器发送的token，并将其和用户名存入浏览器cookie实现单点登录，并发送token用于申请资源
 **/
public class app01_dealWithToken extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String token = request.getParameter("token");
        String username = request.getParameter("username");
        String LOCAL_SERVICE=request.getParameter("LOCAL_SERVICE");
        Cookie cookie =new Cookie("username"+username,token);
        Cookie cookie1=new Cookie("token"+token,LOCAL_SERVICE);
        //设置cookie一个小时后过期
        cookie.setMaxAge(3600);
        cookie1.setMaxAge(3600);
        response.addCookie(cookie);
        response.addCookie(cookie1);
        request.setAttribute("username",username);
        request.setAttribute("token",token);
        request.setAttribute("LOCAL_SERVICE",LOCAL_SERVICE);
        request.getRequestDispatcher("/WEB-INF/jsp/sendToken.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
