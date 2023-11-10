package com.example.lab08.Repository;

import com.example.lab08.Model.Employees;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Component
@Repository
public interface EmployeeRepository extends CrudRepository<Employees,String> {
}
