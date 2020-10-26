package AuthorizationServer;

import Utils.Encryption;
import dao.UserDao;
import domain.User;
import org.apache.oltu.oauth2.as.issuer.MD5Generator;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuer;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuerImpl;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Calendar;

/**
 * @className: AuthorizationServer_sendToken
 * @packageName: AuthorizationServer
 * @description: 用于向请求Token的APP发送Token
 **/
public class AuthorizationServer_sendToken extends HttpServlet {
    /**
     @description:处理doPost请求
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String en_code = request.getParameter("code");
        // code解密
        int key=0x10;
        System.out.println("解密前code: "+en_code);
        String code= Encryption.stringDecryption(en_code,key);
        String username = request.getParameter("username");
        String LOCAL_SERVICE=request.getParameter("LOCAL_SERVICE");
        System.out.println("AuthorizationServer_sendToken");
        System.out.println("code: "+code);
        System.out.println("username: "+username);
        if (code.equals(username)) {
            OAuthIssuer oauthIssuerImpl = null;
            oauthIssuerImpl = new OAuthIssuerImpl(new MD5Generator());
            final String token;
            try {
                //使用oauthIssuerImp对象生成token
                token = oauthIssuerImpl.accessToken();
                User user = UserDao.get(username);
                user.setTk(token);
                Calendar calendar=Calendar.getInstance();
                user.setTct(calendar.getTimeInMillis());
                UserDao.update(user,username);
                request.setAttribute("token", token);
                request.setAttribute("username", username);
                request.setAttribute("LOCAL_SERVICE", LOCAL_SERVICE);
                //获取Session
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("token", token);
            } catch (OAuthSystemException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            //发送Token到“sendToken.jsp“页面
            request.getRequestDispatcher("/WEB-INF/jsp/sendToken.jsp").forward(request, response);
        }
        else{
            response.sendRedirect("http://localhost:8080");
        }
    }
    /**
     @description:处理doGet请求
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
