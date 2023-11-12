package com.store.springecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import com.store.springecommerce.model.Category;
import com.store.springecommerce.service.CategoryService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public ModelAndView category() {
        return new ModelAndView("admin/category");
    }

    @GetMapping("/product")
    public ModelAndView product() {
        List<Category> categories = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("admin/product");
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

}
