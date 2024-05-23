package com.example.demoRegCrud.service;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.web.multipart.MultipartFile;

import com.example.demoRegCrud.entities.Employee;

public interface EmployeeService {

	public void saveEmployee(String name, String gender, List<String> hobbies, Date dob, String address,
			MultipartFile image, String designation) throws IOException, SerialException, SQLException;

	
	public List<Employee> getAllEmployee();
	
	public void deleteById(int id);
	
	public Employee getById(int id);
	


	public void updateEmployee(int id, String name, String gender, List<String> hobbies, Date dob, String address,
			MultipartFile image, String designation) throws SerialException, SQLException, IOException;
}
