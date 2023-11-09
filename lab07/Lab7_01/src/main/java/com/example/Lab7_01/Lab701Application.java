package com.example.Lab7_01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab701Application {

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> System.out.println("Môn công nghệ java");
	}
	public static void main(String[] args) {
		SpringApplication.run(Lab701Application.class, args);
	}
}
