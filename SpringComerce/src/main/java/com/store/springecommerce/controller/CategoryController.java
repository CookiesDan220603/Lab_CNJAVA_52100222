package com.store.springecommerce.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.store.springecommerce.dto.Response;
import com.store.springecommerce.dto.CategoryDTO;
import com.store.springecommerce.model.Category;
import com.store.springecommerce.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Category> categories = categoryService.findAll();
        List<CategoryDTO> categoriesRes = categories.stream().map(c -> new CategoryDTO(c.getId(), c.getName()))
                .toList();
        return ResponseEntity.ok(new Response(0, "Get list category successful", categoriesRes));
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Category category) {
        category.setActive(true);
        categoryService.add(category);
        return ResponseEntity.ok(new Response(0, "Add category successful", ""));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> edit(@PathVariable("id") Long id, @RequestBody Category category) {
        Category foundCategory = categoryService.findCategory(id);

        if (foundCategory == null) {
            return ResponseEntity.ok(new Response(1, "Category with id = " + id + " does not exist", ""));
        }

        foundCategory.setName(category.getName());

        categoryService.update(foundCategory);
        return ResponseEntity.ok(new Response(0, "Update category successful", ""));

    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        Category foundCategory = categoryService.findCategory(id);

        categoryService.delete(foundCategory);
        return new ModelAndView("redirect:/admin/category");

    }

}
