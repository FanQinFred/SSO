package Controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class app02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //检查是否登录
        boolean flag = false;
        String username = "";
        String token ="";
        String LOCAL_SERVICE=request.getParameter("LOCAL_SERVICE");
        Cookie cookies[] = request.getCookies();
        if (cookies != null) {
            for(Cookie cookie:cookies){
                if(cookie.getName().startsWith("username")) {
                    flag = true;
                    username = cookie.getName().substring(8);
                    token=cookie.getValue();
                    break;
                }
            }
        }

        //若已登录
        if(flag){
            request.setAttribute("username",username);
            request.setAttribute("token",token);
            request.setAttribute("LOCAL_SERVICE",LOCAL_SERVICE);
            request.getRequestDispatcher("/WEB-INF/jsp/sendToken.jsp").forward(request, response);
        }
        //若还没有登录
        else{
            String info = request.getParameter("info");
            request.setAttribute("info",info);
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        }
    }
}
