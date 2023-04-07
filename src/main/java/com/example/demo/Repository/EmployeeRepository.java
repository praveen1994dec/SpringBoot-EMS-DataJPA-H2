package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.POJO.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	

	public List<Employee> findByName(String name);

}
