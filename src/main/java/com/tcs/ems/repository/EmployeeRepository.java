package com.tcs.ems.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tcs.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String>{

	Optional<Employee> findByEmail(String email);
	
	@Modifying
	@Query("delete from Employee e where e.email = :email")
	int deleteByEmail(@Param("email") String email);

	boolean existsByEmail(String email);

}
