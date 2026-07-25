package com.excelr.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excelr.project.entity.Employee;




public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}