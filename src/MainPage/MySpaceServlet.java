package MainPage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MySpaceServlet")
public class MySpaceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MySpacedoGet");
     //   if(request.getSession().getAttribute("username")!=null)
        request.getRequestDispatcher("MySpace.jsp").forward(request, response);
     //   else request.getRequestDispatcher("ShareSpace0.jsp").forward(request, response);
    }
}
