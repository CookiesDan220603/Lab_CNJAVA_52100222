package com.store.springecommerce.dto;

import org.springframework.web.multipart.MultipartFile;

import com.store.springecommerce.model.Category;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private String image;
    private String color;
    private String brand;
    private Double price;
    private Long idCategory;
    private String nameCategory;
}
