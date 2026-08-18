package com.tcs.ems.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "Users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Name is required")
	@Size(min = 3, max = 30, message = "Name must be 3 to 30 characters")
	private String name;
	
	@NotBlank(message = "Email is required")
	@Email(message = "Enter a valid email")
	@Column(unique = true)
	private String email;
	
	@Size(min = 6, message="Password must be more than 6")
	private String password;
	
//	@NotBlank(message = "Role is required")
	private String role;
	
//	@NotBlank(message = "Verification status is required")
	private Boolean verified;
	
	private String otp;
	
	private LocalDateTime otpexpirytime;
}
