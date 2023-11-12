package com.store.springecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.springecommerce.model.Order;
import com.store.springecommerce.model.User;
import com.store.springecommerce.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repo;

    public List<Order> findAll() {
        return repo.findAllByActive(true);
    }

    public List<Order> findAllByUser(User user) {
        return repo.findAllByUserAndActive(user, true);
    }

    public Order findOrderById(Long id) {
        Optional<Order> order = repo.findById(id);

        if (order.isPresent()) {
            return order.get();
        }

        return null;
    }

    public void add(Order order) {
        repo.save(order);
    }

    public void update(Order order) {
        repo.save(order);
    }

    public void delete(Order order) {
        if (order.getLstOrderProducts() == null || order.getLstOrderProducts().size() == 0

        ) {
            repo.delete(order);
        } else {
            order.setActive(false);
            update(order);
        }
    }

    public Order findFirstByOrderByIdDesc(User user) {
        return repo.findTopByUserOrderByIdDesc(user);
    }
}
