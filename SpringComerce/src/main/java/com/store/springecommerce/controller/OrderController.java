package com.store.springecommerce.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.store.springecommerce.dto.Cart;
import com.store.springecommerce.dto.OrderStatus;
import com.store.springecommerce.dto.Response;
import com.store.springecommerce.model.Order;
import com.store.springecommerce.model.OrderProduct;
import com.store.springecommerce.model.Product;
import com.store.springecommerce.model.User;
import com.store.springecommerce.service.OrderProductService;
import com.store.springecommerce.service.OrderService;
import com.store.springecommerce.service.ProductService;
import com.store.springecommerce.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderProductService orderProductService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Order> orders = orderService.findAll();

        return ResponseEntity.ok(new Response(0, "Get list order successful", orders));
    }

    @GetMapping("/place")
    public ModelAndView place(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("auth");
        Cart cart = (Cart) session.getAttribute("cart");
        User user = userService.findUserByUsername(username);

        Order order = new Order(null, new Date(), cart.getQuantity(), cart.getTotalPrice(), OrderStatus.PLACED, true,
                new ArrayList<OrderProduct>(), user);
        orderService.add(order);

        Order foundOrder = orderService.findFirstByOrderByIdDesc(user);

        cart.getCartItems().stream().forEach(c -> {
            Product p = productService.findProductById(c.getId());
            OrderProduct orderProduct = new OrderProduct(null, c.getQuantity(), c.getPrice(), c.getTotalPrice(), p,
                    foundOrder);
            orderProductService.add(orderProduct);

            OrderProduct foundOrderProduct = orderProductService.findOrderProduct(p, foundOrder);
            if (p.getLstOrderProducts() == null)
                p.setLstOrderProducts(new ArrayList<OrderProduct>());
            foundOrder.getLstOrderProducts().add(foundOrderProduct);
            p.getLstOrderProducts().add(foundOrderProduct);
            productService.update(p);

        });

        orderService.update(order);
        session.removeAttribute("cart");

        return new ModelAndView("redirect:/order/your-orders");
    }

    @GetMapping("/your-orders")
    public ModelAndView yourOrder(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("user/your-orders");
        String username = (String) session.getAttribute("auth");
        User user = userService.findUserByUsername(username);
        List<Order> orders = orderService.findAllByUser(user);
        modelAndView.addObject("orders", orders);

        return modelAndView;
    }

}
