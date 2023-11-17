package com.example.lab08;

import com.example.lab08.Service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//@SpringBootApplication
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//@EntityScan("com.example.lab08.Model")
public class Lab08Application extends SpringBootServletInitializer {


	private EmployeeServiceImpl employeeServiceImpl;
	public static void main(String[] args) {
		SpringApplication.run(Lab08Application.class, args);
	}
//	@Bean(name="entityManagerFactory")
//	public LocalSessionFactoryBean sessionFactory() {
//		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//
//		return sessionFactory;
//	}
}