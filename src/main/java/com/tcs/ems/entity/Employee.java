package com.tcs.ems.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Entity
@Table(name="Employees")
public class Employee {
	@Id
	@Email(message = "Enter a valid email id")
	@NotBlank(message = "Email field cannot be empty")
	private String email;
	@NotBlank(message = "Name field cannot be empty")
	private String name;
	@Positive(message = "salary should be >= 0")
	private long salary;
	@NotBlank(message = "department field cannot be empty")
	private String department;
}
