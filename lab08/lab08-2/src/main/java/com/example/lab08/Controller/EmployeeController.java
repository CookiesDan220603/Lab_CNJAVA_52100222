package com.example.lab08.Controller;

import com.example.lab08.Model.Employees;
import com.example.lab08.Service.EmployeeServiceImpl;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@Component
@Controller
@RequestMapping("/")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeServiceImp;
    @GetMapping("")
    public String getHomePage(){
        return "redirect:/employee";
    }
    @GetMapping("/employee")
    public String getAllEmployee(Model model){
        model.addAttribute("employees",employeeServiceImp.findAll());
        return "index";
    }
//    @GetMapping("/employee/add")
//    public String getAddEmployee(Model model){
//        model.addAttribute("employee",new Employees());
//        return "add";
//    }
//    @PostMapping("/employee/add")
//    public String postAddEmployee(@ModelAttribute Employees employee){
//        employeeServiceImp.save(employee);
//        return "redirect:/employee";
//    }
//    @GetMapping("/employee/edit/{id}")
//    public String getEditEmployee(@PathVariable("id") int id,Model model){
//        model.addAttribute("employee",employeeServiceImp.findById(id));
//        model.addAttribute("message","Edit");
//        return "add";
//    }
//    @PostMapping("/employee/edit/{id}")
//    public String postEditEmployee(@ModelAttribute Employees employee){
//        employeeServiceImp.save(employee);
//        return "redirect:/employee";
//    }
//    @PostMapping("/employee/delete/{id}")
//    public String postDeleteEmployee(@PathVariable("id") int id){
//        employeeServiceImp.deleteById(id);
//        return "redirect:/employee";
//    }
//    @PostMapping("/employee/delete")
//    public String postDeleteSelectedEmployee(@RequestBody Map<String,Object> body){
//        ArrayList<String> employees_id = (ArrayList<String>) body.get("employees_id");
//        for (String id : employees_id) {
//            employeeServiceImp.deleteById(Long.valueOf(id));
//        }
//        return "redirect:/employee";
//    }
}
