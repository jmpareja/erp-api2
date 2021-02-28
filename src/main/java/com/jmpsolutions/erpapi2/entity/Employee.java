package com.jmpsolutions.erpapi2.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity class for Employee information.
 * 
 * @author jmpareja
 * @since 2021/02/27
 */
@Entity
public class Employee {
	
	// Mark the field 'id' as ignored for JSON
	@JsonIgnore
	private @Id @GeneratedValue Long id;
	private String name;
	private java.sql.Date joindate;
	private Integer age;
	private String company;
	private String email;
	private String phone;
	private Integer salary;
	
	@OneToOne(optional = true)
	private Address address;
	
	/**
	 * Default constructor.
	 */
	public Employee() {}
	
	/**
	 * Constructor with argument values.
	 * @param name String value
	 * @param joindate Date value
	 * @param age Integer value
	 * @param company String value
	 * @param email String value
	 * @param phone String value
	 * @param salary Integer value
	 * @param address Address object
	 */
	public Employee(String name, Date joindate, Integer age, String company, String email, String phone,
			Integer salary, Address address) {
		super();
		this.name = name;
		this.joindate = joindate;
		this.age = age;
		this.company = company;
		this.email = email;
		this.phone = phone;
		this.salary = salary;
		this.address = address;
	}

	/**
	 * Gets field 'id'.
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Sets field 'id' to id.
	 * 
	 * @param id value to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Gets field 'name'.
	 * 
	 * @return name value
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets field 'name'.
	 * 
	 * @param name value to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets field 'joindate'.
	 * 
	 * @return joindate Date object
	 */
	public Date getJoindate() {
		return joindate;
	}
	
	/**
	 * Sets field 'joindate'.
	 * 
	 * @param joindate value to set
	 */
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	
	/**
	 * Gets field 'age'.
	 * 
	 * @return age value
	 */
	public Integer getAge() {
		return age;
	}
	
	/**
	 * Sets field 'age'.
	 * 
	 * @param age value to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	
	/**
	 * Gets field 'company'.
	 * 
	 * @return company value
	 */
	public String getCompany() {
		return company;
	}
	
	/**
	 * Sets field 'company'.
	 * 
	 * @param company value to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	
	/**
	 * Gets field 'email'.
	 * 
	 * @return email value
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets field 'email'.
	 * 
	 * @param email value to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets field 'phone'.
	 * 
	 * @return phone value
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * Sets field 'phone'.
	 * 
	 * @param phone value to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * Gets field 'salary'.
	 * 
	 * @return salary value
	 */
	public Integer getSalary() {
		return salary;
	}
	
	/**
	 * Sets field 'salary'.
	 * 
	 * @param salary value to set
	 */
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
	/**
	 * Gets field 'address' object.
	 * 
	 * @return Address object
	 */
	public Address getAddress() {
		return address;
	}
	
	/**
	 * Sets field 'address' to Address object.
	 * 
	 * @param address object/instance to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

}
