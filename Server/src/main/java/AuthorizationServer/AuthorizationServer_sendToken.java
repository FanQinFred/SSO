package AuthorizationServer;

import Utils.XorEncryption;
import dao.UserDao;
import domain.User;
import org.apache.commons.codec.binary.Base64;
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

public class AuthorizationServer_sendToken extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String en_code = request.getParameter("code");
        // code解密
        int key=0x10;
        String code= XorEncryption.stringEncryption(en_code,key);
        String username = request.getParameter("username");
        String LOCAL_SERVICE=request.getParameter("LOCAL_SERVICE");
        if (code.equals(username)) {
            OAuthIssuer oauthIssuerImpl = null;
            oauthIssuerImpl = new OAuthIssuerImpl(new MD5Generator());
            final String token;
            try {
                token = oauthIssuerImpl.accessToken();
                User user = UserDao.get(username);
                user.setTk(token);
                Calendar calendar=Calendar.getInstance();
                user.setTct(calendar.getTimeInMillis());
                UserDao.update(user,username);
                request.setAttribute("token", token);
                request.setAttribute("username", username);
                request.setAttribute("LOCAL_SERVICE", LOCAL_SERVICE);
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("token", token);
            } catch (OAuthSystemException e) {
                e.printStackTrace();

            } catch (Exception e) {
                e.printStackTrace();
            }
            request.getRequestDispatcher("/WEB-INF/jsp/sendToken.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
