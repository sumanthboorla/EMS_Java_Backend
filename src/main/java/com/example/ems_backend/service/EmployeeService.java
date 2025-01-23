package com.example.ems_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ems_backend.dto.EmployeeDto;

@Service
public interface EmployeeService {
	EmployeeDto createEmployee(EmployeeDto employeedto);
	
	EmployeeDto getEmployeeById(Long employeeId);

	List<EmployeeDto> getAllEmployees();
	
	EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);
	
	void deleteEmployee(Long employeeId);

}
