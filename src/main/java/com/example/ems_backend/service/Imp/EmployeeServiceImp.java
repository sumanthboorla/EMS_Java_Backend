package com.example.ems_backend.service.Imp;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ems_backend.dto.EmployeeDto;
import com.example.ems_backend.entity.Employee;
import com.example.ems_backend.exception.ResourceNotFoundException;
import com.example.ems_backend.mapper.EmployeeMapper;
import com.example.ems_backend.repository.EmployeeRepository;
import com.example.ems_backend.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public EmployeeDto createEmployee(EmployeeDto employeedto) {
		Employee employee = EmployeeMapper.mapToEmployee(employeedto);
		Employee savedEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeedto(savedEmployee);
	}

	public EmployeeDto getEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee not exits in table with given id " + employeeId));
		return EmployeeMapper.mapToEmployeedto(employee);
	}

	// Build get all employee
	public List<EmployeeDto> getAllEmployees() {

		List<Employee> employees = employeeRepository.findAll();

		return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeedto(employee))
				.collect(Collectors.toList());
	}

	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {

		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist in employee table" + employeeId));

		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());
		Employee updatedEmployeeObj = employeeRepository.save(employee);

		return EmployeeMapper.mapToEmployeedto(updatedEmployeeObj);
	}

	@Override
	public void deleteEmployee(Long employeeId) {

		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist in employee table" + employeeId));

		employeeRepository.deleteById(employeeId);

	}

}
