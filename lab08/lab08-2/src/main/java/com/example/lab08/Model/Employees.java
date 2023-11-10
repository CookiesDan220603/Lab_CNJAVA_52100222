package com.example.lab08.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "employees")
@Getter
@Setter
@Component
@AllArgsConstructor
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String email;
    private String phone;

    public Employees(String email, String address, String phone, String name) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;

    }

    public Employees() {

    }
}
