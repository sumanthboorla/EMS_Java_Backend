package com.example.ems_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ems_backend.dto.EmployeeDto;
import com.example.ems_backend.service.EmployeeService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);

	}

	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {

		EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
		return ResponseEntity.ok(employeeDto);
	}

	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
		List<EmployeeDto> employees = employeeService.getAllEmployees();
		return ResponseEntity.ok(employees);

	}

	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployees(@PathVariable("id") Long employeeId,
			@RequestBody EmployeeDto updatedEmployee) {
		EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);

		return ResponseEntity.ok(employeeDto);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
		employeeService.deleteEmployee(employeeId);
		return ResponseEntity.ok("Employee Deleted sucessfully");
	}

}
