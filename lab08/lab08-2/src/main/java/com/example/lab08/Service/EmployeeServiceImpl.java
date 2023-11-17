package com.example.lab08.Service;


import com.example.lab08.Model.Employee;
import com.example.lab08.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class EmployeeServiceImpl {
    private EmployeeService employeeService;

    public Employee save(Employee employee){
        return employeeService.save(employee);
    }
    public Iterable<Employee> findAll(){
        return employeeService.findAll();
    }

    public Employee findById(Long id) {return employeeService.findById(id).get();}

    public void deleteById(Long id) {
        employeeService.deleteById(id);
    }
}