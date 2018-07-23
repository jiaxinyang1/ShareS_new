package MainPage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShareSpace0Servlet")
public class ShareSpace0Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ShareSpace0doGet");
        request.getSession().invalidate();
           String login=new String();
            login="0";
           request.getSession().setAttribute("login",login);
        request.getRequestDispatcher("ShareSpace0.jsp").forward(request, response);
    }
}
