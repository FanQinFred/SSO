package Controller;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class app02_dealWithToken extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String token = request.getParameter("token");
        String username = request.getParameter("username");
        String LOCAL_SERVICE=request.getParameter("LOCAL_SERVICE");
        Cookie cookie =new Cookie("username"+username,token);
        Cookie cookie1=new Cookie("token"+token,LOCAL_SERVICE);
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
