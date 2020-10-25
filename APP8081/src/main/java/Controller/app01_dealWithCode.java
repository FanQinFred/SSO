package Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



/**
 * @className: app01_dealWithCode
 * @packageName: Controller
 * @description: 用于接收服务器发送的code，并将code发送到服务器用于申请token
 **/
public class app01_dealWithCode extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String username = request.getParameter("username");
        String LOCAL_SERVICE=request.getParameter("LOCAL_SERVICE");
        request.setAttribute("code",code);
        request.setAttribute("username",username);
        request.setAttribute("LOCAL_SERVICE",LOCAL_SERVICE);
        request.getRequestDispatcher("/WEB-INF/jsp/requestToken.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
