package com.jmpsolutions.erpapi2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jmpsolutions.erpapi2.entity.Employee;

/**
 * Interface for Employee repository.
 * 
 * @author jmpareja
 * @since 2021/02/27
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}