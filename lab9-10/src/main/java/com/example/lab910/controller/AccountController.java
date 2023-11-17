package com.example.lab910.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.example.lab910.dto.AccountDto;
import com.example.lab910.model.Account;
import com.example.lab910.service.AccountServiceImp;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
public class AccountController {
    @Autowired
    public AccountServiceImp accountServiceImp;

    private final BCryptPasswordEncoder passwordEncoder;
    @PostMapping("/register")
    public ResponseEntity<Account> registerNewAccount(@RequestBody AccountDto accountDto){
        Account account = Account.builder().email(accountDto.getEmail()).password(passwordEncoder.encode(accountDto.getPassword())).build();
        account = accountServiceImp.save(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }
    @PostMapping("/login")
    public ResponseEntity<Account> login(@RequestBody AccountDto accountDto) {
        Account account = accountServiceImp.getAccount(accountDto.getEmail());
        if (account != null) {
            if (passwordEncoder.matches(accountDto.getPassword(), account.getPassword())) {
                return ResponseEntity.status(HttpStatus.OK).body(account);
            }
        }
        return null;
    }
}
