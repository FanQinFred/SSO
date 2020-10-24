package Controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import domain.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class app01_dealWithSource extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String BooksJson = request.getParameter("BooksJson");
        System.out.println("dealWithSource-BooksJson: "+BooksJson);
        Gson gson = new Gson();
        List<Book> Books = gson.fromJson(BooksJson, new TypeToken<List<Book>>(){}.getType());
        if(Books==null){
            System.out.println("Books 为空");
        }
        request.setAttribute("Books",Books);
        request.getRequestDispatcher("/WEB-INF/jsp/showSource.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
