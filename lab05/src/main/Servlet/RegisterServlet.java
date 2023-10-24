package main.Servlet;

import main.DAO.UserDAO;
import main.Model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    UserDAO userDAO = UserDAO.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("username") != null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("register.html").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username").trim();
        String email = request.getParameter("email").trim();
        String password = request.getParameter("password").trim();
        String confirmPassword = request.getParameter("password_confirm").trim();

        if (username.equals("") || email.equals("") || password.equals("") || confirmPassword.equals("")) {
            request.setAttribute("error", "Please fill all fields");
            request.getRequestDispatcher("register.html").forward(request, response);
        } else if (!password.equals(confirmPassword)) {
            request.setAttribute("error", "Password and confirm password must be the same");
            request.getRequestDispatcher("register.html").forward(request, response);
        } else {
            User user = new User(username,password,email);


            if (user == null) {
                request.setAttribute("error", "Username or email already exists");
                request.getRequestDispatcher("register.html").forward(request, response);
            } else {
//               set session
                userDAO.add(user);
                request.getSession().setAttribute("username", username);
                request.setAttribute("username", username);
                request.getRequestDispatcher("login.html").forward(request, response);
            }
        }
    }
}