package com;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.example.Info;
import java.io.IOException;

@WebServlet("/form")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
//        requestDispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("birthday");
        String birthday = req.getParameter("birthday");
        String birthtime = req.getParameter("birthtime");
        String country = req.getParameter("country");
        String toeic = req.getParameter("toeic");
        String message = req.getParameter("message");
        String gender = req.getParameter("gender");
        String[] selectedValues = req.getParameterValues("favorite_ide[]");

        Info t = new Info(name, email, birthday, birthtime, gender, country, selectedValues, Double.parseDouble(toeic), message);
        System.out.println(t); 

        if(name != null && !name.isEmpty() && email != null && !email.isEmpty() && birthtime != null && !birthtime.isEmpty()
                && birthday != null && !birthday.isEmpty() && country != null && !country.isEmpty()
                && toeic != null && !toeic.isEmpty() && gender != null && !gender.isEmpty()
                && message != null && !message.isEmpty() && selectedValues != null && selectedValues.length > 0
        ) {
            Double toeicParam = Double.parseDouble(toeic);
            Info inf = new Info(name, email, birthday, birthtime, gender, country, selectedValues, toeicParam, message);

            req.setAttribute("info", inf);
            RequestDispatcher dispatcher = req.getRequestDispatcher("output.jsp");
            dispatcher.forward(req, resp);

        } else {
            resp.getWriter().println("Loi roi");
        }


    }
}
