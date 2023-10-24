package main.Servlet;

import com.google.gson.Gson;
import main.DAO.ProductDAO;
import main.Model.Product;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "ProductServlet",value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private ProductDAO productDAO; // Khai báo biến productDAO
    private List<Product> productList;
    public void init() throws ServletException {

        super.init();
        // Khởi tạo danh sách sản phẩm
        productList = new ArrayList<>();
        productList.add(new Product("Product 1", 1000));
        productList.add(new Product("Product 2", 1123));
        productList.add(new Product("Product 3", 123213));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Chuyển danh sách sản phẩm thành chuỗi JSON
        String json = new Gson().toJson(productList);

        // Thiết lập các thông số cho phản hồi
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Gửi chuỗi JSON về cho yêu cầu AJAX
        response.getWriter().write(json);
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String message = "";
        System.out.println(name + " " + price);
        // Post add new prod
        if (!Objects.equals(name,"") && !Objects.equals(price,"")) {
            System.out.println(name + " " + price);
            Product newProduct = new Product(name,Integer.parseInt(price));
            productDAO.add(newProduct);
        } else {
            message = "Vui lòng nhập đầy đủ thông tin";
        }

        // Show all prod
        List<Product> products = (List<Product>) productDAO.readAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
    public void destroy(){
        productDAO.close();
    }
}