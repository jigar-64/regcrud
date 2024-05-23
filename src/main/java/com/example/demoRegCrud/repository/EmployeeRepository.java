package com.example.demoRegCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoRegCrud.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
