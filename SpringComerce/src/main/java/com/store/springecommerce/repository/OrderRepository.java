package com.store.springecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.springecommerce.model.Order;
import com.store.springecommerce.model.User;

import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    public List<Order> findAllByActive(boolean active);

    public List<Order> findAllByUserAndActive(User user, boolean active);

    public Order findTopByUserOrderByIdDesc(User user);
}
