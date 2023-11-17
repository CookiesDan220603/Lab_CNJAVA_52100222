package com.example.lab910.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lab910.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
