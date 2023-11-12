package com.store.springecommerce.dto;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class CartItem {
    private Long id;
    private String name;
    private String brand;
    private String color;
    private double price;
    private String image;
    private int quantity;
    private Double totalPrice;

}
