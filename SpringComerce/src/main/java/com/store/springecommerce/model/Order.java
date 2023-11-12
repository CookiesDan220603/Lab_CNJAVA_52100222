package com.store.springecommerce.model;

import java.util.Date;
import java.util.List;

import com.store.springecommerce.dto.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date orderDate;
    private int quantity;
    private Double totalPrice;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private boolean active;

    @OneToMany(mappedBy = "order")
    private List<OrderProduct> lstOrderProducts;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
