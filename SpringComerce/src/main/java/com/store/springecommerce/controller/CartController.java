package com.store.springecommerce.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.store.springecommerce.dto.Response;
import com.store.springecommerce.model.Product;
import com.store.springecommerce.service.ProductService;
import com.store.springecommerce.dto.Cart;
import com.store.springecommerce.dto.CartItem;
import com.store.springecommerce.dto.CartRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ModelAndView get(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView modelAndView = new ModelAndView("user/cart");
        if (session.getAttribute("cart") == null) {
            return new ModelAndView("redirect:/");
        } else {
            Cart cart = (Cart) session.getAttribute("cart");
            List<CartItem> products = cart.getCartItems();
            modelAndView.addObject("products", products);
            modelAndView.addObject("cart", cart);

            return modelAndView;
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> add(@RequestBody CartRequest cartRequest, HttpServletRequest request) {

        Long id = cartRequest.getId();
        Product product = productService.findProductById(id);

        if (product == null) {
            return ResponseEntity.ok(new Response(1, "Product does not exist", ""));
        }

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        int quantity = cartRequest.getQuantity();
        double priceCartItem = quantity * product.getPrice();

        if (cart == null) {
            cart = new Cart();
            List<CartItem> cartItems = new ArrayList<CartItem>();

            double cartTotal = priceCartItem;
            CartItem cartItem = new CartItem(id, product.getName(), product.getBrand(), product.getColor(),
                    product.getPrice(), product.getImage(), quantity, priceCartItem);

            cartItems.add(cartItem);
            cart.setQuantity(1);
            cart.setTotalPrice(cartTotal);
            cart.setCartItems(cartItems);

            session.setAttribute("cart", cart);

            return ResponseEntity.ok(new Response(0, "Add and creat cart successful", ""));
        } else {
            int cartQuantity = quantity + cart.getQuantity();
            double cartTotal = cart.getTotalPrice();
            cartTotal += priceCartItem;

            List<CartItem> cartItems = cart.getCartItems();
            boolean exist = false;
            for (int i = 0; i < cartItems.size(); i++) {
                CartItem item = cartItems.get(i);
                if (item.getId() == product.getId()) {
                    int newQuantity = item.getQuantity() + quantity;
                    double newTotalPrice = item.getTotalPrice() + priceCartItem;

                    item.setQuantity(newQuantity);
                    item.setTotalPrice(newTotalPrice);

                    cartItems.set(i, item);
                    exist = true;

                }
            }

            if (!exist) {
                CartItem cartItem = new CartItem(id, product.getName(), product.getBrand(), product.getColor(),
                        product.getPrice(), product.getImage(), quantity, priceCartItem);
                cartItems.add(cartItem);
            }

            cart.setQuantity(cartQuantity);
            cart.setTotalPrice(cartTotal);
            cart.setCartItems(cartItems);

            session.setAttribute("cart", cart);
            return ResponseEntity.ok(new Response(0, "Update cart list successful", ""));
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody CartItem cartItemParam,
            HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");

        List<CartItem> cartItems = cart.getCartItems();

        for (int i = 0; i < cartItems.size(); i++) {
            if (cartItems.get(i).getId() == id) {
                CartItem current = cartItems.get(i);
                current.setQuantity(cartItemParam.getQuantity());
                Double price = cartItemParam.getQuantity() * current.getPrice();
                Double cartPrice = cart.getTotalPrice() + price - current.getTotalPrice();
                current.setTotalPrice(price);
                cart.setTotalPrice(cartPrice);
            }
        }

        cart.setCartItems(cartItems);
        session.setAttribute("cart", cart);
        return ResponseEntity.ok(new Response(0, "Update cart list successful", ""));
    }
}
