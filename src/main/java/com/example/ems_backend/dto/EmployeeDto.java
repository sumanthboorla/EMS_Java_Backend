package com.example.ems_backend.dto;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import lombok.Getter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	private Long id;
	private String firstName;
	private String lastName;
	private String email; 
	
	public EmployeeDto(Long id2, String firstName2, String lastName2, String email2) {
		
		setId(id2);
		setFirstName(firstName2);
		setLastName(lastName2);
		setEmail(email2);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
