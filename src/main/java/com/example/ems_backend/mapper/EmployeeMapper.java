package com.example.ems_backend.mapper;

import com.example.ems_backend.dto.EmployeeDto;
import com.example.ems_backend.entity.Employee;

public class EmployeeMapper {

	public static EmployeeDto mapToEmployeedto(Employee employee)
	{
		return new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail());
				
	}
	public static Employee mapToEmployee(EmployeeDto employeedto)
	{
		return new Employee( employeedto.getId(), employeedto.getFirstName(),employeedto.getLastName(),employeedto.getEmail());
	}
}
