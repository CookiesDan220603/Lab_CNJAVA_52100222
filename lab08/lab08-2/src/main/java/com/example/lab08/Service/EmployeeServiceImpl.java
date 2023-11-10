package com.example.lab08.Service;


import com.example.lab08.Model.Employees;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class EmployeeServiceImpl {
    private EmployeeService employeeService;

    public void init(){
        save(new Employees(1,"a.@gmail.com","Tan phong, quan 7","0141414561","Tran Van Thao"));
        save(new Employees(2,"b.@gmail.com","Tan phong, quan 7","01244219744","Tran Van Teo"));
        save(new Employees(3,"c.@gmail.com","Tan phong, quan 7","014141423561","Tran Van Lord"));
    }

    public Employees save(Employees employees){
        return employeeService.save(employees);
    }
    public Iterable<Employees> findAll(){
        return employeeService.findAll();
    }
    public Employees findByid(int id){return employeeService.findById(String.valueOf(id)).get();}

    public void deleteById(int id){
        employeeService.deleteById(String.valueOf(id));
    }
}
