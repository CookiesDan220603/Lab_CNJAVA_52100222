package com.example.lab08;

import com.example.lab08.Model.Employees;
import com.example.lab08.Service.EmployeeService;
import com.example.lab08.Service.EmployeeServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@ComponentScans({})
//@SpringBootApplication
@Configuration
//@EnableAutoConfiguration
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class Lab08Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Lab08Application.class, args)
				.getBean(EmployeeServiceImpl.class)
				.init();
	}
}