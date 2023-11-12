package com.store.springecommerce.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.store.springecommerce.model.Category;
import com.store.springecommerce.model.Product;
import com.store.springecommerce.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> findAll() {
        return repo.findAllByActive(true);
    }

    public Product findProductById(Long id) {
        Optional<Product> product = repo.findById(id);

        if (product.isPresent()) {
            return product.get();
        }

        return null;
    }

    public void add(Product product) {
        repo.save(product);
    }

    public void update(Product product) {
        repo.save(product);
    }

    public void delete(Product product) {
        if (product.getLstOrderProducts() == null || product.getLstOrderProducts().size() == 0)
            repo.delete(product);
        else {
            product.setActive(false);
            update(product);
        }
    }

    public boolean uploadImage(MultipartFile image) {
        if (image.isEmpty()) {
            return false;
        }

        try {

            String destinationDir = "src/main/resources/static/images/"; // Đường dẫn thư mục cần di chuyển
            Path destinationPath = Paths.get(destinationDir + image.getOriginalFilename());
            Files.createDirectories(destinationPath.getParent()); // Tạo thư mục nếu chưa tồn tại
            Files.write(destinationPath, image.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public List<Product> findAllByCategoryAndActive(Category category) {
        return repo.findAllByCategoryAndActive(category, true);
    }

    public List<Product> findAllByBrandAndActive(String brand) {
        return repo.findAllByBrandAndActive(brand, true);
    }

    public List<Product> findAllByColorAndActive(String color) {
        return repo.findAllByColorAndActive(color, true);
    }
}
