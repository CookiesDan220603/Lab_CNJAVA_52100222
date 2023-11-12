package com.store.springecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.store.springecommerce.dto.AuthRequest;
import com.store.springecommerce.dto.Response;
import com.store.springecommerce.model.User;
import com.store.springecommerce.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public ModelAndView showRegister() {
        return new ModelAndView("user/register");
    }

    @GetMapping("/login")
    public ModelAndView showLogin() {
        return new ModelAndView("user/login");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        User foundUser = userService.findUserByUsername(user.getUsername());

        if (foundUser != null) {
            return ResponseEntity.ok(new Response(1, "Existed user", ""));
        }
        userService.add(user);

        return ResponseEntity.ok(new Response(0, "Register successful", ""));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest, HttpSession session) {
        User user = userService.findUserByUsername(authRequest.getUsername());
        if (user == null) {
            return ResponseEntity.ok(new Response(1, "User does not exist in database", ""));
        } else {
            if (!user.getPassword().equals(authRequest.getPassword())) {
                return ResponseEntity.ok(new Response(1, "Wrong passowrd", ""));
            } else {
                session.setAttribute("auth", authRequest.getUsername());
                return ResponseEntity.ok(new Response(0, "Login successful", ""));
            }
        }
    }
}
