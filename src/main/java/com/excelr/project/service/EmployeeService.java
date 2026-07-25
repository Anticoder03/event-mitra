package com.excelr.project.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.project.entity.Employee;
import com.excelr.project.exception.ResourceNotFoundException;
import com.excelr.project.repository.EmployeeRepository;




@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Employee addEmployee(Employee employee){
        return repository.save(employee);
    }

    public List<Employee> getAllEmployees(){
        return repository.findAll();
    }

    public Employee getEmployeeById(Integer id){

        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee Not Found"));
    }

    public Employee updateEmployee(Integer id, Employee employee){

        Employee emp=getEmployeeById(id);

        emp.setName(employee.getName());
        emp.setDepartment(employee.getDepartment());
        emp.setSalary(employee.getSalary());

        return repository.save(emp);
    }

    public String deleteEmployee(Integer id){

        Employee emp=getEmployeeById(id);

        repository.delete(emp);

        return "Employee Deleted Successfully";
    }

}