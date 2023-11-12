package com.store.springecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.store.springecommerce.model.User;
import com.store.springecommerce.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User findUserByUsername(String username) {
        return repo.findByUsername(username);
    }

    public void add(User user) {
        repo.save(user);
    }
}
