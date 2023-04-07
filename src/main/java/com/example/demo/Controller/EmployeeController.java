package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.POJO.Employee;
import com.example.demo.Service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "index";
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
	
	@PostMapping("/add")
	//To fetch the object data from browser and bind to employee POJO
	public String addEmployee(@ModelAttribute Employee employee) {
		
		employeeService.addEmployee(employee);
		
		return "redirect:/";
		
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showUpdateForm(@PathVariable Long id, Model model) {
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);

		return "update_employee";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmployeeById(@PathVariable Long id, Model model) {
		employeeService.deleteEmployeeById(id);

		return "redirect:/";
	}
	
	

}
