
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Objects;

@WebServlet (name = "HomeServlet", value = "/HomeServlet")
public class HomeServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World! @ 123";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String page = request.getParameter("page");

        if(page == null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
        else if(page.equals("help")){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/help.jsp");
            dispatcher.forward(request, response);
            System.out.println(page);
        }
        else if(page.equals("contact")){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/contact.jsp");
            dispatcher.forward(request, response);
            System.out.println(page);
        }
        else if(page.equals("about")){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/about.jsp");
            dispatcher.forward(request, response);
            System.out.println(page);
        }
        else {
            response.setContentType("text/html");
            PrintWriter pw=response.getWriter();
            pw.write("Welcome to our website");
            pw.close();
        }
    }

    public void destroy() {
    }
}