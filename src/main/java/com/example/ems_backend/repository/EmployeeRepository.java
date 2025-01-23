package com.example.ems_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.ems_backend.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Custom query methods can be added here
//	@Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
//	   Optional<Employee> findById(Long id);
}
