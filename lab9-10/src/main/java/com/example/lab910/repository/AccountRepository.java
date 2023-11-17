package com.example.lab910.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import com.example.lab910.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findAccountByEmailEquals(String email);

    Account findAccountByEmailEqualsAndPasswordEquals(String email, String password);
}
