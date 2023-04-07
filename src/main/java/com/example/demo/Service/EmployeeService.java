package com.example.demo.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.POJO.Employee;
import com.example.demo.Repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee addEmployee(Employee e) {
		return employeeRepository.save(e);
		
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Employee getEmployeeById(Long id) {
		
		Employee emp = employeeRepository.getById(id);

		if (emp == null) {
			throw new RuntimeException("Employee not found");
		}
		return emp;
	}

	public String deleteEmployeeById(Long id) {

		Employee emp = employeeRepository.getById(id);

		if (emp == null) {
			throw new RuntimeException("Employee not found");
		}

		employeeRepository.deleteById(id);
		return "Deleted: " + emp.getName();
	}

}
