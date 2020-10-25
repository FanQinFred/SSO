package Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @className: app01_register
 * @packageName: Controller
 * @description: 用于跳转到注册页面
 **/
public class app01_register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("info","PleaseInputYourUsernameAndPasswordToRegister.");
        String info = request.getParameter("info");
        if(info!=null)
            request.setAttribute("info",info);
        request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
    }
}
