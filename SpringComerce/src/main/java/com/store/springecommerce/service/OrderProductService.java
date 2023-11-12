package com.store.springecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.springecommerce.model.Order;
import com.store.springecommerce.model.OrderProduct;
import com.store.springecommerce.model.Product;
import com.store.springecommerce.repository.OrderProductRepository;

@Service
public class OrderProductService {

    @Autowired
    private OrderProductRepository repo;

    public List<OrderProduct> findAll() {
        return repo.findAll();
    }

    public List<OrderProduct> findAllByProduct(Product product) {
        return repo.findAllByProduct(product);
    }

    public OrderProduct findOrderProduct(Product product, Order order) {
        return repo.findByProductAndOrder(product, order);
    }

    public void update(OrderProduct orderProduct) {
        repo.save(orderProduct);
    }

    public void add(OrderProduct orderProduct) {
        repo.save(orderProduct);
    }

}
