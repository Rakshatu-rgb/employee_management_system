package com.tcs.ems.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.ems.entity.Employee;
import com.tcs.ems.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@PostMapping("/insert")
	public String insertEmployee(@Valid @RequestBody Employee employee) {
		//return employeeService.insertEmployee(employee);
		return "data registered";
	}
	
	@GetMapping("/{email}")
	public Object fetchEmployeeByEmail(@PathVariable String email) {
		return employeeService.fetchEmployeeByEmail(email);
	}
	
	@GetMapping("/fetchAllEmp")
	public List<Employee> fetchAllEmployees() {
		return employeeService.fetchAllEmployees();
	}
	
	@DeleteMapping("/{email}")
	public String deleteEmployeeByEmail(@PathVariable String email) {
		return employeeService.deleteEmployeeByEmail(email);
	}
	
	@PutMapping("/update")
	public String updateEmpData(@RequestBody Employee employee) {
		return employeeService.updateEmpData(employee);
	}
	
}
