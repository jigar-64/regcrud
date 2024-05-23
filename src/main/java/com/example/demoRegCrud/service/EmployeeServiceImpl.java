package com.example.demoRegCrud.service;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demoRegCrud.entities.Employee;
import com.example.demoRegCrud.entities.Hobbies;
import com.example.demoRegCrud.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository empRepo;
	
	


	@Override
	public void saveEmployee(String name, String gender, List<String> hobbies, Date dob, String address,
			MultipartFile image, String designation) throws IOException, SerialException, SQLException {
		Employee emp = new Employee();
		emp.setAddress(address);
		emp.setDate(dob);
		emp.setDesignation(designation);
		emp.setGender(gender);
		emp.setName(name);
		List<Hobbies> list=new ArrayList<>();
		for (String hobbie : hobbies) {
			Hobbies h = new Hobbies();
			h.setName(hobbie);
			list.add(h);
		}
		emp.setHobbies(list);
		if (!image.isEmpty()) {
			emp.setImage(new SerialBlob(image.getBytes()));
		}
		empRepo.save(emp);
		
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

	@Override
	public void deleteById(int id) {
		empRepo.deleteById(id);
		
	}

	@Override
	public Employee getById(int id) {
		
		return empRepo.findById(id).get();
	}

	@Override
	public void updateEmployee(int id, String name, String gender, List<String> hobbies, Date dob, String address,
			MultipartFile image, String designation) throws SerialException, SQLException, IOException {
		Employee emp = getById(id);
		emp.setAddress(address);
		emp.setDate(dob);
		emp.setDesignation(designation);
		emp.setGender(gender);
		emp.setName(name);
		List<Hobbies> list=new ArrayList<>();
		for (String hobbie : hobbies) {
			Hobbies h = new Hobbies();
			h.setName(hobbie);
			list.add(h);
		}
		emp.setHobbies(list);
		if (!image.isEmpty()) {
			emp.setImage(new SerialBlob(image.getBytes()));
		}
		empRepo.save(emp);
		
	}

	

}
