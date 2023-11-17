package com.example.lab910.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.lab910.model.Account;
import com.example.lab910.model.Product;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class ProductOrderDto {
    private Long id;
    private Product product;
    private Account account;
    private Integer quantity;
}
