package com.jmpsolutions.erpapi2.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmpsolutions.erpapi2.entity.Employee;
import com.jmpsolutions.erpapi2.repository.EmployeeRepository;
import com.jmpsolutions.erpapi2.util.ErpApiUtil;

/**
 * Controller class for employee-related API mapping to methods.
 * 
 * @author jmpareja
 * @since 2021/02/27
 */
@RestController
@RequestMapping(value="/api")
public class EmployeeController {

	private final EmployeeRepository repository;
	
	EmployeeController(EmployeeRepository repository) {
		this.repository = repository;
	}
	
	/**
	 * Fetches all employee entries.
	 * 
	 * @return List of Employee objects
	 */
	@GetMapping("/employees")
	List<Employee> all() {
		return repository.findAll();
	}
	
	/**
	 * Fetches all employee entries sorted by specified field.
	 * 
	 * @param field Employee field for sorting
	 * @return List of sorted Employee objects
	 */
	@GetMapping("/sorted/{field}")
	List<Employee> getSorted(@PathVariable String field) {	
		return repository.findAll().stream()
				.sorted(ErpApiUtil.getComparatorBasedOnField(field)).collect(Collectors.toList());
	}
	
	/**
	 * Fetches Employee objects with age value lesser than specified parameter.
	 * 
	 * @param age integer value of age
	 * @return List of Employee objects satisfying criteria
	 */
	@GetMapping("/younger/than/{age}")
	List<Employee> getYoungerThanAge(@PathVariable int age) {
		return repository.findAll().stream().filter(item -> (age > item.getAge())).collect(Collectors.toList());
	}
}
