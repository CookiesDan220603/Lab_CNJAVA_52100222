package com.store.springecommerce.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private int quantity;
    private Double totalPrice;
    private String address;
    private List<Long> productIds;
}
