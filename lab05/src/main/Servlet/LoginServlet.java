package main.Servlet;

import main.DAO.UserDAO;
import main.Model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private UserDAO userDAO;
    @Override
    public void init(){
        userDAO = UserDAO.getInstance();
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");


        String messageErr = "";
        User user = userDAO.read(username);
        if(user==null){
            RequestDispatcher dispatcher = req.getRequestDispatcher("/register.html");
            dispatcher.forward(req,resp);
        }

        else{
            if(user.getPassword()!= null && user.getPassword().equals(password)){
                System.out.print(username+"    "+password +"\n");
//                Cookie cookie = new Cookie("username", username);
//                cookie.setMaxAge(60 * 60 * 24 * 30); // 30 days
//                resp.addCookie(cookie);
                Cookie cookie = new Cookie("username", username);
                cookie.setMaxAge(60 * 60 * 24 * 30); // 30 days
                resp.addCookie(cookie);
                req.getSession().setAttribute("username", username);
                req.setAttribute("username", username);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
                dispatcher.forward(req,resp);
            }
            else {
                RequestDispatcher dispatcher = req.getRequestDispatcher("/login.html");
                dispatcher.forward(req,resp);
            }
        }

    }
    public void destroy(){
        userDAO.close();
    }
}