package com.example.demoRegCrud.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demoRegCrud.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployee());

		return "index";
	}

	@GetMapping("/register-form")
	public String registerPage() {
		return "register";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@RequestParam("name") String name, @RequestParam("gender") String gender,
			@RequestParam("hobbies") List<String> hobbies, @RequestParam("dob") Date dob,
			@RequestParam("address") String address, @RequestParam("image") MultipartFile image,
			@RequestParam("designation") String designation) throws IOException, SerialException, SQLException {
		employeeService.saveEmployee(name, gender, hobbies, dob, address, image, designation);
		return "redirect:/"; // Redirect to a success page (create result.html)
	}

	@GetMapping("/delete/{id}")
	public String deleteBYId(@PathVariable int id) {
		employeeService.deleteById(id);
		return "redirect:/";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("emp", employeeService.getById(id));
		return "update";
	}

	@PostMapping("/update/saveUpdate/{id}")
	public String updateEmployee(@PathVariable int id, @RequestParam("name") String name,
			@RequestParam("gender") String gender, @RequestParam("hobbies") List<String> hobbies,
			@RequestParam("dob") Date dob, @RequestParam("address") String address,
			@RequestParam(name = "image", required = false) MultipartFile image,
			@RequestParam("designation") String designation) throws IOException, SerialException, SQLException {
		employeeService.updateEmployee(id, name, gender, hobbies, dob, address, image, designation);
		// Save employee to the database (not implemented here)
		return "redirect:/"; // Redirect to a success page (create result.html)
	}
}
