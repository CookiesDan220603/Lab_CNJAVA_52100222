package com.store.springecommerce.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    private int quantity;
    private double totalPrice;
    private List<CartItem> cartItems;
}
