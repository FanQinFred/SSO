package Controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @className: app01
 * @packageName: Controller
 * @description: 用于检查是否登录，如果已登录则使用token访问资源，若未登录则跳转登录页面登录
 **/
public class app01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
// include《》
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //检查是否登录
        boolean flag = false;
        String username = "";
        String token ="";
        String LOCAL_SERVICE=request.getParameter("LOCAL_SERVICE");
        //在浏览器cookie中寻找带有该服务器特殊标记的cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for(Cookie cookie:cookies){
                if(cookie.getName().startsWith("username")) {
                    flag = true;
                    //获取用户名
                    username = cookie.getName().substring(8);
                    //获取token
                    token=cookie.getValue();
                    break;
                }
            }
        }

        //若已登录，直接发送token获取资源
        if(flag){
            request.setAttribute("username",username);
            request.setAttribute("token",token);
            request.setAttribute("LOCAL_SERVICE",LOCAL_SERVICE);
            request.getRequestDispatcher("/WEB-INF/jsp/sendToken.jsp").forward(request, response);
        }
        //若还没有登录，跳转登录页面
        else{
            String info = request.getParameter("info");
            request.setAttribute("info",info);
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        }
    }
}
