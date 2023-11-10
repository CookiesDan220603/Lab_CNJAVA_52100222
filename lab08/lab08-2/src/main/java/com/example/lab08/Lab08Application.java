package com.example.lab08;

import com.example.lab08.Model.Employees;
import com.example.lab08.Service.EmployeeService;
import com.example.lab08.Service.EmployeeServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@ComponentScans({})
@SpringBootApplication
public class Lab08Application implements CommandLineRunner{
private EmployeeServiceImpl employeeServiceImpl;
	public static void main(String[] args) {

		SpringApplication.run(Lab08Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("hello");
	}

}
