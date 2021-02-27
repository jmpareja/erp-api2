package com.jmpsolutions.erpapi2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jmpsolutions.erpapi2.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}