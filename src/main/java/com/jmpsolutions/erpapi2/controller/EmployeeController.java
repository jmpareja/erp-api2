package com.jmpsolutions.erpapi2.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmpsolutions.erpapi2.entity.Employee;
import com.jmpsolutions.erpapi2.repository.EmployeeRepository;
import com.jmpsolutions.erpapi2.util.FieldNotFoundException;

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
	
	@GetMapping("/sorted/{field}")
	List<Employee> getSorted(@PathVariable String field) {
		Comparator<Employee> myComparator = null;
		switch(field) {
			case "name":
				myComparator = Comparator.comparing(Employee::getName);
				break;
			case "joindate":
				myComparator = Comparator.comparing(Employee::getJoindate);
				break;
			case "age":
				myComparator = Comparator.comparing(Employee::getAge);
				break;
			case "company":
				myComparator = Comparator.comparing(Employee::getCompany);
				break;
			case "email":
				myComparator = Comparator.comparing(Employee::getEmail);
				break;
			case "phone":
				myComparator = Comparator.comparing(Employee::getPhone);
				break;
			case "salary":
				myComparator = Comparator.comparing(Employee::getSalary);
				break;
			default:
				throw new FieldNotFoundException(field);
		}
		return repository.findAll().stream()
				.sorted(myComparator).collect(Collectors.toList());
	}
	
	@GetMapping("/younger/than/{age}")
	List<Employee> getYoungerThanAge(@PathVariable int age) {
		return repository.findAll().stream().filter(item -> (age > Integer.parseInt(item.getAge()))).collect(Collectors.toList());
	}
}
