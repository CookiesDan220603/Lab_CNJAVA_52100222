package com.example.lab08.Model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Entity
@AllArgsConstructor
@Table(name = "employee")
@Getter
@Setter
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
