package com.excelr.project.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.project.entity.Employee;
import com.excelr.project.service.EmployeeService;





@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    // Create
    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee){
        return service.addEmployee(employee);
    }

    // Read All
    @GetMapping
    public List<Employee> getAllEmployees(){
        return service.getAllEmployees();
    }

    // Read One
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id){
        return service.getEmployeeById(id);
    }

    // Update
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Integer id,
                                   @RequestBody Employee employee){

        return service.updateEmployee(id, employee);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Integer id){

        return service.deleteEmployee(id);
    }

}
