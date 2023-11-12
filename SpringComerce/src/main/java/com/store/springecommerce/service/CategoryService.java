package com.store.springecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.springecommerce.model.Category;
import com.store.springecommerce.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repo;

    public List<Category> findAll() {
        return repo.findAllByActive(true);
    }

    public Category findCategory(Long id) {
        Optional<Category> category = repo.findById(id);

        if (category.isPresent()) {
            return category.get();
        }

        return null;
    }

    public void add(Category category) {
        repo.save(category);
    }

    public void update(Category category) {
        repo.save(category);
    }

    public void delete(Category category) {
        if (category.getLstProducts() == null || category.getLstProducts().size() == 0)
            repo.delete(category);
        else {
            category.setActive(false);
            update(category);
        }
    }
}
