package Controller;

import Utils.HttpUtil;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class app01_logout extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie []cookies = request.getCookies();
        String username = null;
        for(Cookie cookie:cookies){
            if (cookie.getName().startsWith("username")) {
                username = cookie.getName().substring(8);
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
        String info = request.getParameter("info");
        HttpUtil.sendPost("http://localhost:8080/SourceOwner_logout","username="+username);
        request.setAttribute("info",info);
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
    }
}
