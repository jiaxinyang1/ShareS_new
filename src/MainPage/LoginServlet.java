package MainPage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    public void init(){
        DataManage.init();

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("username"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LogindoGet");
        String url="ShareSpace1.jsp";
        String password = request.getParameter("password");
        String username=request.getParameter("username");
        String login;
        request.getSession().setAttribute("user", username);
        request.getSession().setAttribute("password", password);
        for(int i=0;i<DataManage.userData.getList().size();i++)
        {
            if (DataManage.userData.getList().get(i).getEmail().equals(username) && DataManage.userData.getList().get(i).getPassword().equals(password))
            {
                System.out.println("登陆成功");
                login=new String("登录成功");
                request.setAttribute("login",login);
                request.getRequestDispatcher(url).forward(request, response);
                return;
            }
        }
        login=new String("用户名或密码错误");
        request.setAttribute("login",login);
        System.out.println("登陆失败");
        request.getRequestDispatcher("ShareSpace0").forward(request, response);
        request.setAttribute("flag","false");
        //登录失败



    }
}
