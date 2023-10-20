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
                Cookie ck = new Cookie("username",username);
                Cookie ck1 = new Cookie("password",password);
                // set due time 30 days
                ck.setMaxAge(2592000);
                ck1.setMaxAge(2592000);
                resp.addCookie(ck);
                resp.addCookie(ck1);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/index.html");
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