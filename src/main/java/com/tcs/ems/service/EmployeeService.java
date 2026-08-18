package com.tcs.ems.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tcs.ems.entity.Employee;
import com.tcs.ems.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService {
	private EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public String insertEmployee(Employee employee) {
		employeeRepository.save(employee);
		return "Employee Inserted";
	}

	public Object fetchEmployeeByEmail(String email) {
		Optional<Employee> oe=employeeRepository.findByEmail(email);
		if(oe.isPresent()) {
			return oe.get();
		}else {
			return "Employee with email not present";
		}
	}

	public List<Employee> fetchAllEmployees() {
		return employeeRepository.findAll();
	}

	@Transactional
	public String deleteEmployeeByEmail(String email) {
		Optional<Employee> oe=employeeRepository.findByEmail(email);
		if(oe.isEmpty()) {
			return "Employee with email " + email + " is not found";
		}else {
			employeeRepository.deleteByEmail(email);
			return "Employee with email " + email + " deleted";
		}
	}

	public String updateEmpData(Employee employee) {

	    if (employeeRepository.existsByEmail(employee.getEmail())) {
	        employeeRepository.save(employee);
	        return "Employee info updated successfully";
	    }

	    return "Employee not found";
	}	
}
