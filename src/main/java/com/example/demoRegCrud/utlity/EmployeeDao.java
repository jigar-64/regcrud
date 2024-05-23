package com.example.demoRegCrud.utlity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demoRegCrud.entities.Employee;
import com.example.demoRegCrud.service.EmployeeService;
import com.example.demoRegCrud.service.EmployeeServiceImpl;

@Component
public class EmployeeDao {

	@Autowired
	EmployeeService employeeService = new EmployeeServiceImpl();

//	@Autowired
//	EmployeeRepository employeeRepository;

	public List<Employee> getAllEmp() {
		return employeeService.getAllEmployee();
		// return employeeRepository.findAll();
	}
}
