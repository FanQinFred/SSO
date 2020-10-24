package SourceServer;

import com.google.gson.Gson;
import dao.BookDao;
import dao.UserDao;
import domain.Book;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

public class SourceOwner_sendSource extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //接受username和token
        String username = request.getParameter("username");
        String token = request.getParameter("token");
        String LOCAL_SERVICE=request.getParameter("LOCAL_SERVICE");
        User user = null;
        String tk = null;
        long tct=0;
        long curr_tct=0;
        Calendar calendar=Calendar.getInstance();
        curr_tct=calendar.getTimeInMillis();
        try {
            user = UserDao.get(username);
            if(user!=null)
                tk = user.getTk();
                tct=user.getTct();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //在session和数据库中验证关联性
        if(((curr_tct-tct)<3600000)&&tk!=null&&token.equals(tk)) {
            //如果成功
            List<Book> Books = null;
            try {
                Books = BookDao.getAll(LOCAL_SERVICE);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Gson gson = new Gson();
            String BooksJson = gson.toJson(Books);
            BooksJson = BooksJson.replaceAll(" ", "_");
            System.out.println("BooksJson: " + BooksJson);
            request.setAttribute("BooksJson", BooksJson);
            request.setAttribute("LOCAL_SERVICE", LOCAL_SERVICE);
            request.getRequestDispatcher("/WEB-INF/jsp/sendSource.jsp").forward(request, response);
        }
        else
            response.sendRedirect(LOCAL_SERVICE+"?info=TokenIsWrong.");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

