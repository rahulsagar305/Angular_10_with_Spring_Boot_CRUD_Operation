package com.crud.rs.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.crud.rs.model.Employee;
import com.crud.rs.repository.EmployeeRepository;
import com.crus.rs.exception.ResourceNotFoundException;

@RestController
@CrossOrigin
@RequestMapping(value="/api/1.0")
public class EmployeeController { 	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	

	
	@GetMapping ("/rahul")
	public String hello(@RequestParam(value="name",defaultValue = "Rahul") String name) {
		
		return String.format("My Name Is Rahul", name);
		
	}
	// get all employees
		@GetMapping("/employees")
		public List<Employee> getAllEmployees(){
			return employeeRepository.findAll();
		}

		
		// create employee Rest API
		@PostMapping("/employees")
		public Employee createwmployee(@RequestBody Employee employee) {
			return employeeRepository.save(employee);
		}
		
		
		// get employee details using id
		@GetMapping("/employees/{id}")
		public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
			
			Employee employee = employeeRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Employees Not Found "+id));
			return ResponseEntity.ok(employee);  	 	
		}
		
		// Update Employee 
		@PutMapping("employees/{id}")
		public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employeeDetails){
			
			Employee employee = employeeRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Employees Not Found "+id));
			if (employee!=null) {
				Employee updateEmployee = employeeRepository.save(employeeDetails);
				return ResponseEntity.ok(updateEmployee);	
			}else {
				return ResponseEntity.ok(employee);	
			}
		}
		
		
		// Delete Employee 
		@DeleteMapping("/employees/{id}")
		public ResponseEntity <Map<String, Boolean>> deleteEmployee (@PathVariable Long id) {
			Employee employee = employeeRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Employees Not Found "+id));
			if (employee!=null) {
					employeeRepository.delete(employee);
					Map<String , Boolean> response = new HashMap<>();
					response.put("Deleted",Boolean.TRUE);
					return ResponseEntity.ok(response);	
			}else {
				return null;
			}
			
		}
}
  