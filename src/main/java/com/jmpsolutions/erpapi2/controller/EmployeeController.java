package com.jmpsolutions.erpapi2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmpsolutions.erpapi2.entity.Employee;
import com.jmpsolutions.erpapi2.repository.EmployeeRepository;

@RestController
@RequestMapping(value="/api")
public class EmployeeController {

	private final EmployeeRepository repository;
	
	EmployeeController(EmployeeRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/employees")
	List<Employee> all() {
		return repository.findAll();
	}
}
