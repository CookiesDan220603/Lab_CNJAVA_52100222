package com.example.lab910.service;

import com.example.lab910.model.Product;

public interface ProductService {
    Product save(Product products);

    Product update(Product products);

    void delete(Long product_id);

    Iterable<Product> findAll();

    Product findById(Long id);
}
